package com.ucardstore.service;

import com.ucardstore.Constants;
import com.ucardstore.Exceptions.PostcardException;
import com.ucardstore.dao.PostcardDao;
import com.ucardstore.dao.UserDao;
import com.ucardstore.entity.Postcard;
import com.ucardstore.entity.User;
import com.ucardstore.model.AddPostcard;
import com.ucardstore.result.AddPostcardResult;
import com.ucardstore.result.Result;
import com.ucardstore.tool.EmailTool;
import com.ucardstore.tool.ImageTool;
import com.ucardstore.tool.UCSTool;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by YUAN on 2016/9/6.
 */
@Service("postcardService")
public class PostcardServiceImpl implements PostcardService {
    @Resource private UserDao userDao;

    @Resource private PostcardDao postcardDao;

    private UCSTool UCStool = new UCSTool();
    private ImageTool imageTool = new ImageTool();

    private Postcard postcard = new Postcard();
    private Result result = new Result();
    private AddPostcardResult addPostcardResult = new AddPostcardResult();



    @Transactional
    @Override
    public Result addPostcard(AddPostcard addPostcard) throws Exception {

        User user = userDao.findUserByToken(addPostcard.getToken());
        if(user==null){
            throw new PostcardException("无效的token");
        }
        String userID = user.getUserID();

        String originalCountryCode = addPostcard.getOriginalCountryCode();
        //收货国家缩写
        String goalCountryCode = addPostcard.getGoalCountryCode();
        //用户所在国家缩写
        String sendCountryCode = addPostcard.getSendCountryCode();




        String orderSerialNumber = UCStool.generateorderSerialNumber();
        String cardID = UCStool.generatePostcardID();


        String frontPic = addPostcard.getFrontPic();
        String backPic = addPostcard.getBackPic();
        String edgeBackPic = addPostcard.getEdgeBackPic();


        try {
            imageTool.processPostcardImg(frontPic,backPic,edgeBackPic,cardID);
        } catch (Exception e) {
            throw new PostcardException("保存失败"+e,e);
        }

        postcard.setUserID(userID);
        postcard.setCardID(cardID);
        postcard.setRecName(addPostcard.getRecName());
        postcard.setCreateTime(DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now()));
        postcard.setAr(addPostcard.isAr());
        postcard.setHorizon(addPostcard.isHorizon());
        postcard.setOrderSerialNumber(orderSerialNumber);
        postcard.setSendAddress(addPostcard.getSendAddress());
        postcard.setReceiveAddress(addPostcard.getReceiveAddress());
        postcard.setContent(addPostcard.getContent());
        
        postcard.setOriginalCountryCode(originalCountryCode);
        postcard.setGoalCountryCode(goalCountryCode);
        postcard.setSendCountryCode(sendCountryCode);
        postcard.setCaption(addPostcard.getCaption());
        postcard.setVideoID(addPostcard.getVideoID());
        postcard.setImageID(addPostcard.getImageID());
        if(originalCountryCode.equals("EN")||goalCountryCode.equals("EN")||sendCountryCode.equals("EN")){
            postcard.setPriceEUR(3.99d);
            addPostcardResult.setPriceEUR(3.99d);
        }else{
            postcard.setPriceRMB(29.99d);
            addPostcardResult.setPriceRMB(29.99d);
        }

        postcardDao.addPostcard(postcard);


        addPostcardResult.setOrderSerialNumber(postcard.getOrderSerialNumber());
        addPostcardResult.setUserID(postcard.getUserID());
        addPostcardResult.setCardID(postcard.getCardID());
        addPostcardResult.setCreateTime(postcard.getCreateTime());

        result.setCode(Constants.SUCCESS);
        result.setData(addPostcardResult);
        result.setMsg("添加成功");
        return result;
    }



    public Result findPostcardByID(String cardID) {

        Postcard postcard = postcardDao.findPostcardByID(cardID);
        if(postcard==null){
            throw new PostcardException("cardID错误");
        }
        result.setCode(Constants.SUCCESS);
        result.setMsg("查询成功");
        result.setData(postcard);
        return result;
    }

    @Override
    public Result findPostCards(Integer page) {
        List<Postcard> postList= postcardDao.findPostcard((page-1)*20);
        result.setCode(Constants.SUCCESS);
        result.setMsg("查询成功");
        result.setData(postList);
        return result;
    }

    @Override
    public Result savePic(String string, String name)  {
        try {
            imageTool.savePic(string ,name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public boolean track(String cardID,String receiveTime) {
        try{
            postcardDao.postcardRec(receiveTime,cardID);
        }catch (Exception e){
            return false;
        }
        return true;
    }


}
