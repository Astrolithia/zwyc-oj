package com.zwyc.zwycoj.judge;

import com.zwyc.zwycoj.judge.strategy.DefaultJudgeStrategy;
import com.zwyc.zwycoj.judge.strategy.JavaLanguageJudgeStrategy;
import com.zwyc.zwycoj.judge.strategy.JudgeContext;
import com.zwyc.zwycoj.judge.strategy.JudgeStrategy;
import com.zwyc.zwycoj.model.dto.questionsubmit.JudgeInfo;
import com.zwyc.zwycoj.model.entity.QuestionSubmit;

/**
 * 判题管理（简化调用）
 */
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if (language.equals("java")) {
            judgeStrategy = new JavaLanguageJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }
}
