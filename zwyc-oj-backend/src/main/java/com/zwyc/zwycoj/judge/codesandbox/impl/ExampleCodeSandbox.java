package com.zwyc.zwycoj.judge.codesandbox.impl;

import com.zwyc.zwycoj.judge.codesandbox.CodeSandbox;
import com.zwyc.zwycoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.zwyc.zwycoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.zwyc.zwycoj.model.dto.questionsubmit.JudgeInfo;
import com.zwyc.zwycoj.model.enums.JudgeInfoMessageEnum;
import com.zwyc.zwycoj.model.enums.QuestionSubmitStatusEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * 示例代码沙箱（仅为了跑通业务流程）
 */
@Slf4j
public class ExampleCodeSandbox implements CodeSandbox {

    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setTime(100L);
        judgeInfo.setMemory(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;
    }
}
