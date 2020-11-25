package com.cryingbear.blog.controller;

import com.alibaba.fastjson.JSON;
import com.cryingbear.blog.utils.AESUtils;
import net.sf.json.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wx")
public class WxController {
    private RestTemplate restTemplate = new RestTemplate();


    @PostMapping("/login")
    public String wxLogin(){

        String url = "https://api.weixin.qq.com/sns/jscode2session?appid=wxedd0146dca64d070&secret=703fca16a46ce2de3ee1af0842cb208f&js_code=011WO5200LG2HK1XHy1005DwEH1WO526&grant_type=authorization_code";

        HttpHeaders headers = new HttpHeaders();
        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        //放入Http传输的数据
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(multiValueMap,headers);
        //访问接口并获取返回值

        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url,httpEntity,String.class);



        return responseEntity.getBody();
    }


    @PostMapping("/decrypt")
    public List wxDecrypt(){
        String encryptedData = "n7qynGVZyVC4cSCTayy9X+iRJy3eYjXnF9bPhDFFN8MSvatX0DaZOockecKqWm69rZUz65AAyb0/tlPxrXpvkIVKz5Tf9cn8B4XEkLhphIaevJ0FZhUdFdTItkBKJjjUpupZNYoVQ99NKd0eiu/cgHu3Rutt6/D6/Vm6oweTCr4WcP5mDJhftra7Yffe67uswlEiqy6NCZ/xVdikjyFctVz1ohKop//8tnSJxeCDWvZFNxmft8MRcgW8DHwqKaAocpVIy85PYqnI+eL+Mw3LvZsO4LwaUylA78w1JiDcdVmqfiXydhS2KyAjqTvPA2zkYgKLoAxqiRGbpyHqRthuPu/B+cQW9tBPfkC+tMWj/7SqteiPuuCCk051i/ttzJ+Awu/9L9/jMjIIk345C7yiT18n5NIUITKeP5Ydouy92lZhN/lod/qgnVXgF7L+oIj5opHxlXLEMjiA1fhBlmry1Ir/CkHlbiwYXVwgSqS+vm3d8uBEJHNUhUgTuh8u6ekPT6XZSD9f5QNVyWHm4PcSX0sAmn8yvMrawv1mE4JpWYFzr0xcZe+2zv5FsxeGhKCtm5kgGQfCZTV1gVIbBXIBySCfSLR2UdYXIVQHw6iId2UvIapk6XIjXoNV09oZHqZyoVSjULE2Vz26iz+FiQ+e4H5j1aJbuJ7d+IULELN5FHt79y+coJwswOISDugLuJu8+6qwxwSnTlrTz4qZDqSJ6fBvN5B00jSQEJYkRURh08kjCop5DL7vjUC+RSJUnCd72c8hqpXQfspwtIIt6NKsiUi0FW0zzs/GnS42euls1UEvG/s0j+ZKJvTRiL7TW6C+78n9vek18v8AJKpPN0aMJ6SNvC2e6jWvsyvrMfr22nb2eCz2Lu4B5XHk9VltjucoPZfwXxq+TGiBA6jIMB3uvc2hiNL8rUUMTO87mamwsFvl736L2tTjso4361ruQBq0ZfgFVz45Hl2dgZFP1E1FqZfKRCGY32KoXGvQfbcPj66q3GRXbBp139p+fPQgTnS+ewj2xIpEXUhXRPl3xCPZYpa6nPoiJmkApVhtY3mffDxEw5WiaBuEtjblvfYL1OQb1OYzgMHK1oaHZT4AexJz2QO3U/9xMtua8Qv846RxcD9eGkCNEc6Hlf+DrpHpcMh5dRUlv/ZWTadxac5DUulos9kaTehLYGjfQ2WZFmr5L4ggG6OWVf37zVmDsvOtrA98u+Pf52+7phGNe8Xsz+zxPcqev3BS/w6SxqDwAjL4kuAJMJV/+EP6XjCnOsHu4SUX/wE7hVGGZpjjmEUdSt74HKqt32sbmAspqol3sYV3USNkdDSA74uomAGvjErSrIIIG9ljwrm8hBzycBo/yiczZ6N+ObzaU5gpf+0bFU3crHpnZjvbzrI94/xMe9xtbXLSl2hy2ESDFjlF00wy5yiSg3ponTQbomj0bCL41YBlV9OfgQBUwW10qNsnnHTZd+Iu4aY+VWs3kkTp6MZydJhB312n6lx+wo7gpItImFYLru6tVfab01/0QC60JzBeLMGlbJ9v+wrs54gh+oRW9GrwcudnyF3xWDfI5uW6hCoGBA1XyV7F2CupAdb8mKfwg5imn1ydmWRwpvZjLHfP+6ged7WzlrITKLQhUn+KfZMiDHc=";
        String iv = "kLEXpM14DWZA+X0Xrp7AjQ==";
        String sessionKey = "XkdXWdaYLkwrCJMjBfILVg==";
        int days = 10;

       List list =  decrypt(encryptedData,iv,sessionKey,days);


       for(int i=0;i < list.size();i++) {
           Object tempObj = list.get(i);
           Map map = new HashMap<>();
           if(!StringUtils.isEmpty(tempObj.toString())){
               //先转成json字符，再转回json对象，JSON实际上是实现Map接口的子类，所以可以直接赋值给Map对象
              map  = JSON.parseObject(JSON.toJSONString(tempObj));
              Long timestamp = Long.parseLong(map.get("timestamp").toString())*1000L;
               SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
               String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timestamp))));
               System.out.println("我是日期"+sd+"，我是步数"+map.get("step"));
           }
       }

        return list;
    }


    public List decrypt(String encryptedData, String iv, String sessionKey, Integer days){
        JSONObject run = null;
        List list=null;
        try {
            byte[] resultByte  = AESUtils.decrypt(Base64.decodeBase64(encryptedData),
                    Base64.decodeBase64(sessionKey),
                    Base64.decodeBase64(iv));
            String userInfo = new String(resultByte, "UTF-8");
            run = net.sf.json.JSONObject.fromObject(userInfo);
            list = run.getJSONArray("stepInfoList");
            System.out.println(list.size());
            System.out.println(list);
        }catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return list;
    }

}

