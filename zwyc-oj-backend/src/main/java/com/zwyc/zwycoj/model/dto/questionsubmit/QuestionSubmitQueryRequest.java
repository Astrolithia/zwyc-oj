package com.zwyc.zwycoj.model.dto.questionsubmit;

import com.zwyc.zwycoj.common.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * 创建请求
 *
 * @author <a href="https://github.com/lizwyc">程序员鱼皮</a>
 * @from <a href="https://zwyc.icu">编程导航知识星球</a>
 */
@Data
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    /**
     * 编程语言
     */
    private String language;

    /**
     * 提交状态
     */
    private Integer status;

    /**
     * 题目 id
     */
    private Long questionId;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}