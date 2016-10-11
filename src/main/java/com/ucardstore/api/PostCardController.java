package com.ucardstore.api;

import com.ucardstore.Constants;
import com.ucardstore.Exceptions.PostcardException;
import com.ucardstore.model.AddPostcard;
import com.ucardstore.result.Result;
import com.ucardstore.service.PostcardService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * Created by YUAN on 2016/9/5.
 */
@RestController
@RequestMapping(value = "/postcard")
public class PostCardController {

    @Resource
    private PostcardService postcardService;
    private Result result= new Result();

    @RequestMapping(value = "/addPostcard",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public Result addPostCard(@RequestBody @Validated AddPostcard addPostcard) throws Exception {
        result = postcardService.addPostcard(addPostcard);
        return result;
    }


    @RequestMapping(value = "/selectPostcards/{page}",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseStatus(value= HttpStatus.OK)
    public Result selectPostcards(@PathVariable(value = "page") Integer page){

        result = postcardService.findPostCards(page);
        return result;
    }

    @RequestMapping(value = "/findOnePostcard/{cardID}",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public Result findPostCard(@PathVariable(value ="cardID")String cardID){
        result = postcardService.findPostcardByID(cardID);
        return result;
    }


//    @RequestMapping(value = "/save/{str}",method = {RequestMethod.POST,RequestMethod.GET})
//    @ResponseStatus(value= HttpStatus.OK)
//    public void save(@PathVariable(value = "str") String str) throws IOException {
//        System.out.println(str);
//    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseStatus(value= HttpStatus.OK)
    public void save(@RequestParam(value="str") String str) throws IOException {
        System.out.println(str);
    }

    @RequestMapping(value = "/tracking/{cardID}",method = RequestMethod.GET)
    public String track(@PathVariable(value ="cardID") String cardID) throws IOException {
        String recTime= DateTimeFormatter.ofPattern("yyyyMMddHHmmss").withZone(ZoneOffset.UTC).format(Instant.now());
        if(postcardService.track(recTime,cardID)) {
            return "welcome";
        }
        else{
            return "error";
        }

    }



    @ResponseStatus(value=HttpStatus.BAD_REQUEST)
    @ExceptionHandler(PostcardException.class)
    public Result PostcardExceptionHandler(PostcardException e){
        result.setCode(Constants.FAIL);
        result.setMsg(e.getMessage());
        result.setData(null);
        return result;
    }

}
