package com.family.algorithem2101;

import com.deepoove.poi.XWPFTemplate;
import com.deepoove.poi.data.HyperlinkTextRenderData;
import com.deepoove.poi.data.PictureRenderData;
import com.deepoove.poi.data.TextRenderData;
import org.apache.commons.codec.binary.Base64;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

<<<<<<< HEAD
=======
/**
 *资源下添加
 * doc/TL.docx
 * doc/outTL.docx
 * static/1.png
 */
>>>>>>> fa7b44aabe0ca4ef8ff284a1d77666b94eb5f1af
public class TLDemo {
    public static void main(String[] args) throws IOException {
        byte[] base64 = Base64.decodeBase64("iVBORw0KGgoAAAANSUhEUgAAAyAAAAH0CAYAAADFQEl4AAAgAElEQVR4Xu3dD4wlV33g+9Pj2HjGfzaj4U+cQIDJkiEB5BUiPJax2WBtMIkUwhIRsxrb7OIYW2AgE5EXlGCwGZKXPFAmgG0ZiFnweLI4JDwFJIIJcViwWZ4XIawFLYaNgfDHCjBDYsDjwXj6qS6vmjt3+nafW7fur+6p+owUEZi6dU59zume/nbV7V5ZXV1dTf4QIECAAAECBAgQIEAgQGBFgAQoG4IAAQIECBAgQIAAgZGAALERCBAgQIAAAQIECBAIExAgYdQGIkCAAAECBAgQIEBAgNgDBAgQmFPggWOr6eQtK3OexcunCqw+mNLKSYAIECBAoCcCAqQnC+kyCBDIF3jF/7w/vfurD6Rvfr+9n8HxsFNW0gseeXJ605NOzZ9IX4/8xoGU7v3vKT34nfau8KQzUjrz36b08IvaO6czESBAgEAnAgKkE3aDEiDQlUAVH2+5+/sLG/5lO08ZdoRU8fHtDy3MN21/lghZnK4zEyBAIERAgIQwG4QAgWUReMTffKfVOx+T11XdCfmnXz5j08u9//7705/+6Z+mCy64ID32sY9d9/jqmLe//e3poosuSj/+4z+e3ve+96XXve51a8e+8IUvTC972ctG//2LX/xi+od/+Id0zjnnrL3mox/9aHrkIx85+vvbb7997dj6BNX5X//616cPfvCD647/xCc+cTTHauzsP//7Je3e+ZgcuLoT8q+vmzqdT33qU+mrX/1qes5znjM6ZppzddyLX/zi0TGT1/mOd7wjPfOZzzxuXZbGN3shHEiAAIHlFRAgy7s2ZkaAQMsC1Xs1HvL+Fh8LmjK/o796RtZ7Qv75n/85vfGNb0yvfOUr1/0if70AqYLiyU9+8ig4/v7v/z696EUvWptFFSg7duxI1RfXp512WnroQx86+kK8+t/r141PefL8uX83dVmq92p8/j+1vGrrnO5n3zn1PSGTAVI53Xzzzem3fuu30qmn/ujxuPq4ZzzjGenAgQPpYQ972Ggt1vvzmte8Zs2xU9/FyxqBAAECIQICJITZIAQILIvAlr++d+FTOfZrZ54wRvWF8Mtf/vJ0zz33bDr+2972ttEdi3e9611rx1Z3Ox796EevhcRkgEzeHalf+Ed/9EfppptuSp/5zGfWzvXsZz87vfrVrx7999bvgNwV8B6NXQeOM5x2J6e6ztNPPz395V/+5XHHV5a7d+8e3Smpwqy+YzIeK9U5x+NwaXw33T0OIECAwPILCJDlXyMzJECgRYGuAmS9S5j8bv3kMdUXxNUjUFdfffXaI1gb3QGpXl99ofx3f/d36YwzzhhFxoc+9KF0xx13jP7/yS+qW78DUk2ggwAZdxs3raOv8pu8a1Qd9/nPfz5985vfTD/3cz+XXvWqV03dZeOPaHXu2+LHglMRIECgKwEB0pW8cQkQ6ESgpACpv+tefwFcv6djvUew6rsAv/zLvzx6BKv6ovpb3/pWuu+++9I3vvGNdPnll6dvf/vba48jVe8tGb/DstFi1HdMxh9hmnr8EgVI9V6Obdu2jf6vehRtPE6q///Tn/50uvvuu0ePwFX/Ofk+mfFAq669ulvUuW8nHzUGJUCAQLsCAqRdT2cjQGDJBUoJkOqL3z//8z8fxcOznvWs0RfL1Xs6pt0Bqd84fdZZZ43ehP785z8/feQjH0nPfe5z02233ZZ+5md+ZhQg42/Qrt6DUr3/4dJLLx29P2L8C/ScN8mvu9RLFCDV/MavsXKpHr2qAq6+1voRrOo/6zelj19XHX/vfe97R29M79x3yT++TI8AAQI5AgIkR8kxBAj0RqCrANnsJ07VwPXdhurRqfoNz/VPwRr/6UzrvQl9o5/4VH13v/pTfwFef3FevTl7/P0h4wtdfbH95je/eepP6VqmABn/qVb1vKr30vz8z//86DG2pzzlKen973//2uNsk29Cr6Ok/qli1TkmH1FbCt/efCS6EAIEhiwgQIa8+q6dwAAFugqQ9ag3eg/Ihz/84dEXzdUdiipAqjsU4z+Stw6Q5z3veaM3S1c/Kvfd7373ccNMvtm8+svqvSD1o1R9ugMyaTn+k7/qOKl/mlXlUB//pCc9afRY2rnnnpte8YpXnLBM9R2Qah0mH1nrxHeAH7MumQCB/gkIkP6tqSsiQGADgVICZPI78OPv36gCYjxAqi+Oq8e0rrvuutF3+Ov3K1RxUn1nvwqN6k5H9ZhRHSD1/zbt7kdNOPNdkI4ewdooQOr30kwGSP3I1fj/Xl33ej+2ePwHAnTq66ObAAECPRAQID1YRJdAgEC+wLL8IsLx78LXvzRv8irGHwGqImP88ak6QKr3JdS/D2QyKuofN1t9oV09jlS9/6P+iVjrvaF8s5/KlaXc0S8iXO8RrDe96U3pb/7mb0bTrt5oXt0pesQjHjH6hYzr/bSsaT8iub4LUp1n/JG1TnyzFsFBBAgQWG4BAbLc62N2BAi0LPCK/3l/esvd32/5rD863ct2npLe9KQf/cK7+m/e8pa3zPxTp6rX1m+crt4TMv7L9MZjo/oO/pe//OXRj9wdf89G9UV29d/Hf5t59b+95z3vGU3rb//2b7McZvopWN84kNK3P5R13kYHbX9WSg8/8XeNrBdPlXn1u1PGA6/636o/9e8BWS/+1rsDUr1uKXwboXkRAQIElktAgCzXepgNAQIBAlWEvPurD6Rvfn+1tdEedspKesEjT143PlobpJQTVRFy739P6cEWf+v8SWekdOa/XTc+SmExTwIECBD4oYAAsRMIECAwp8ADx1bTyVtW5jyLl08VWH0wpZWTABEgQIBATwQESE8W0mUQIECAAAECBAgQKEFAgJSwSuZIgAABAgQIECBAoCcCAqQnC+kyCBAgQIAAAQIECJQgIEBKWCVzJECAAAECBAgQINATAQHSk4V0GQQIECBAgAABAgRKEBAgJaySORIgQIAAAQIECBDoiYAA6clCugwCBAgQIECAAAECJQgIkBJWyRwJECBAgAABAgQI9ERAgPRkIV0GAQIECBAgQIAAgRIEBEgJq2SOBAgQIECAAAECBHoiIEB6spAugwABAgQIECBAgEAJAgKkhFUyRwIECBAgQIAAAQI9ERAgPVlIl0GAAAECBAgQIECgBAEBUsIqmSMBAgQIECBAgACBnggIkJ4spMsgQIAAAQIECBAgUIKAAClhlcyRAAECBAgQIECAQE8EBEhPFtJlECBAgAABAgQIEChBQICUsErmSIAAAQIECBAgQKAnAgKkJwvpMggQIECAAAECBAiUICBASlglcyRAgAABAgQIECDQEwEB0pOFdBkECBAgQIAAAQIEShAQICWskjkSIECAAAECBAgQ6ImAAOnJQroMAgQIECBAgAABAiUICJASVskcCRAgQIAAAQIECPREQID0ZCFdBgECBAgQIECAAIESBARICatkjgQIECBAgAABAgR6IiBAerKQLoMAAQIECBAgQIBACQICpIRVMkcCBAgQIECAAAECPREQID1ZSJdBgAABAgQIECBAoAQBAVLCKpkjAQIECBAgQIAAgZ4ICJCeLKTLIECAAAECBAgQIFCCgAApYZXMkQABAgQIECBAgEBPBARITxbSZRAgQIAAAQIECBAoQUCAlLBK5kiAAAECBAgQIECgJwICpCcL6TIIECBAgAABAgQIlCAgQEpYJXMkQIAAAQIECBAg0BOBhQfIwYMH04UXXngC10033ZT27NnTE0aXQYAAAQIECBAgQIBAjsDCA2RyEnfddVe66qqr0jXXXJN27NiRM0fHECBAgAABAgQIECDQE4HwANm3b18677zz0u7du3tC6DIIECBAgAABAgQIEMgVCA2Q6u7HDTfckK6++uq0devWDef41Kc+dfT3d9xxR+61OI4AAQIECBAgQIAAgSUXCA2Qje5+bNu2LR05cuQErsOHDy85oekRIECAAAECBAgQKEdg+/btnU42LEBmfe/HysrKCObYsWOdAhmcAAECBAgQIECAQJ8E6q+zu7qmsACp7n7s3Lkz+ydfCZCutoRxCRAgQIAAAQIE+iwwiACpHq167Wtfmy655JK0a9eurPUUIFlMDiJAgAABAgQIECAwk8AgAmTWx68qQQEy0z5yMAECBAgQIECAAIEsgUEESJbExEECpIma1xAgQIAAAQIECBDYWECATPERID50CBAgQIAAAQIECLQvIEAESPu7yhkJECBAgAABAgQIbPJ1dldAYT8Fa9YLdAdkVjHHEyBAgAABAgQIENhcwB0Qd0A23yWOIECAAAECBAgQINCSgAARIC1tJachQIAAAQIECBAgsLmAABEgm+8SRxAgQIAAAQIECBBoSUCACJCWtpLTECBAgAABAgQIENhcQIAIkM13iSMIECBAgAABAgQItCQgQARIS1vJaQgQIECAAAECBAhsLiBABMjmu8QRBAgQIECAAAECBFoSECACpKWt5DQECBAgQIAAAQIENhcQIAJk813iCAIECBAgQIAAAQItCQgQAdLSVnIaAgQIECBAgAABApsLCBABsvkucQQBAgQIECBAgACBlgQEiABpaSs5DQECBAgQIECAAIHNBQSIANl8lziCAAECBAgQIECAQEsCAkSAtLSVnIYAAQIECBAgQIDA5gICRIBsvkscQYAAAQIECBAgQKAlAQEiQFraSk5DgAABAgQIECBAYHMBASJANt8ljiBAgAABAgQIECDQkoAAESAtbSWnIUCAAAECBAgQILC5gAARIJvvEkcQIECAAAEC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33cs7fzw95b2ch69bUu6+9+ftrTzG8rE6ieNurre8ACpfiLWFVdcka666qq0a9euqdddwwiQrraGcQn8SECABO8GARICLkBCmNcGESAx3gIkxrn0UXofINXjVx/4wAfS3r17R2vlDkjpW9b8hyggQIJXXYCEgAuQEGYBEsucBEgweKHD9T5A6ui48MILR0s06+8BcQek0J1t2r0SECDByylAQsAFSAizAIllFiDB3qUON4gAabI4HsFqouY1BBYjIEAW4zr1rAIkBFyAhDALkFhmARLsXepwAmTKygmQUre0efdRQIAEr6oACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1OgAiQUveueQ9IQIAEL7YACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1OgAiQUveueQ9IQIAEL7YACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1OgAiQUveueQ9IQIAEL7YACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1OgAiQUveueQ9IQIAEL7YACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1OgAiQUveueQ9IQIAEL7YACQEXICHMAiSWWYAEe5c6nAARIKXuXfMekIAACV5sARICLkBCmAVILLMACfYudTgBIkBK3bvmPSABARK82AIkBFyAhDALkFhmARLsXepwAkSAlLp3zXtAAgIkeLEFSAi4AAlhFiCxzAIk2LvU4QSIACl175r3gAQESPBiC5AQcAESwixAYpkFSLB3qcMJEAFS6t417wEJCJDgxRYgIeACJIRZgMQyC5Bg71KHEyACpNS9a94DEhAgwYstQELABUgIswCJZRYgwd6lDidABEipe9e8ByQgQIIXW4CEgAuQEGYBEsssQIK9Sx1uEAFy++23p3POOWe0RmeffXa6+eab065duzZcsxrm2LFjpa6teRPojYAACV5KARICLkBCmAVILLMACfYudbjeB8ihQ4fSddddl175ylemrVu3pipG9u3b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");
        ByteArrayInputStream in = new ByteArrayInputStream(base64);
        BufferedImage image = ImageIO.read(in);
        Map<String, Object> datas = new HashMap<String, Object>() {
            {
                put("Name", new TextRenderData("33ff33", "Alex Bin"));
                put("Age", "24");
                put("Sources", new HyperlinkTextRenderData("baidu", "http://www.baidu.com"));
                // 本地图片 可以绝对路径但不推荐
                put("Image", new PictureRenderData(120, 120, new ClassPathResource("static/1.png").getFile().getPath()));
                //java图片/base64等格式图片
<<<<<<< HEAD
=======

>>>>>>> fa7b44aabe0ca4ef8ff284a1d77666b94eb5f1af
                put("JavaImage", new PictureRenderData(600, 350, ".png", BytePictureUtils.getBufferByteArray(image)));
            }
        };
        ClassPathResource oldDoc = new ClassPathResource("doc/TL.docx");
        ClassPathResource newDoc= new ClassPathResource("doc/outTL.docx");
        String filePath = oldDoc.getFile().getPath();
        String outPath = newDoc.getFile().getPath();
<<<<<<< HEAD
        XWPFTemplate template = XWPFTemplate.compile(filePath)
                .render(datas);
=======
        XWPFTemplate template = XWPFTemplate.compile(filePath).render(datas);
>>>>>>> fa7b44aabe0ca4ef8ff284a1d77666b94eb5f1af
        FileOutputStream out = new FileOutputStream(outPath);
        template.write(out);
        out.flush();
        out.close();
        template.close();
    }
}
