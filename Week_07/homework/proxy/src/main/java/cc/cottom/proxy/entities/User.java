package cc.cottom.proxy.entities;

import cc.cottom.proxy.constant.SexType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;



@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String username;
    private String password;
    private String nickname;
    private String realname;
    private String face;
    private String mobile;
    private SexType sex;
    private Date birthday;
    private Date createAt;
    private Date updateAt;
}
