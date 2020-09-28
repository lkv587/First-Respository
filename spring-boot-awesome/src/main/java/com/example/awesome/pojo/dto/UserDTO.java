package com.example.awesome.pojo.dto;

import com.example.awesome.service.base.Create;
import com.example.awesome.service.base.Update;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * @ClassName: UserDTO
 * @Description: 用户传输对象
 * @Author: lkv587
 * @Date: 2020/9/28 9:57
 **/
@Data
public class UserDTO implements Serializable {

    /** 用户ID */
    @NotNull(message = "用户ID不能为空", groups = Update.class)
    private Long id;

    /** 用户名 */
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名不能超过20个字符")
    @Pattern(regexp = "^[\\u4E00-\\u9FA5A-Za-z0-9\\*]*$", message = "用户昵称限制：最多20字符，包含文字、字母和数字")
    private String username;

    /** 密码 */
    private String password;

    /** 手机号 */
    @NotBlank(message = "手机号码不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号码格式有误", groups = {Create.class,Update.class})
    private String mobile;

    /** 性别 */
    private String gender;

    /** 邮箱 */
    @NotBlank(message = "邮箱不能为空")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message = "邮箱格式有误")
    private String email;

    /** 身份证号码 */
    @NotBlank(message = "身份证号码不能为空")
    @Pattern(regexp = "^[1-9]\\\\d{5}(18|19|([23]\\\\d))\\\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\\\d{3}[0-9Xx]$", message = "身份证号码有误")
    private String idcard;

}
