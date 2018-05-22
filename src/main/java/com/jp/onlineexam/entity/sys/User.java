package com.jp.onlineexam.entity.sys;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.rkpunjal.sqlsafe.SQLInjectionSafe;
import com.jp.onlineexam.entity.common.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * TODO:
 *
 * @author <a href="mailto:zhangtylord@gmail.com>张俊鹏</a>
 * @see
 * @since 5/17/2018
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "sys_user")
public class User {

    private static final long serialVersionUID = 2355356131655543873L;

    @Id
    @Generated
    @ApiModelProperty(value = "ID")
    private Long id;

    @ApiModelProperty("用户姓名")
    @NotBlank(message = "姓名不能为空")
    @SQLInjectionSafe
    private String name;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty("用户登陆名")
    private String username;

    @NotBlank(message = "密码不能为空")
    @SQLInjectionSafe
    private String password;

    @SQLInjectionSafe
    @NotBlank(message = "salt不能为空")
    private String salt;

    @SQLInjectionSafe
    @NotBlank(message = "角色不能为空")
    private String role;

    @NotBlank(message = "邮箱不能为空")
    @Email(message = "邮箱格式不正确")
    @SQLInjectionSafe
    @ApiModelProperty("用户邮箱")
    private String email;

    @SQLInjectionSafe
    @NotBlank(message = "性别不能为空")
    @ApiModelProperty("性别 1:男 0:女")
    private String gender;

    @SQLInjectionSafe
    @ApiModelProperty("用户手机号")
    private String mobile;

    @SQLInjectionSafe
    @ApiModelProperty("用户头像")
    private String avatar;

    /**
     * 状态  0：禁用   1：正常
     */
    @ApiModelProperty("用户状态:0：禁用   1：正常")
    private Integer status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据创建时间")
    @Column(name = "create_date")
    protected Date createDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME, pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "数据更新时间")
    @Column(name = "update_date")
    protected Date updateDate;

    public User(String name, String username, String password, String salt, String role, String email, String gender, String mobile, String avatar, Integer status) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
        this.email = email;
        this.gender = gender;
        this.mobile = mobile;
        this.avatar = avatar;
        this.status = status;
    }

    public void SetRole(String role) throws Exception {
        if (Role.isRole( role )) {
            this.role = role;
        } else {
            throw new Exception( "illegal role" );
        }
    }

    public void preInsert() {
        this.updateDate = new Date();
        if (this.createDate == null) {
            this.createDate = this.updateDate;
        }
    }

    public void preUpdate() {
        this.updateDate = new Date();
    }
}
