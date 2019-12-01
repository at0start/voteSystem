package newthread.votesystem.controller;

import com.xuxueli.poi.excel.ExcelExportUtil;
import newthread.votesystem.bean.*;
import newthread.votesystem.bean.webBean.SRUid;
import newthread.votesystem.bean.webBean.UserVoteInfo;
import newthread.votesystem.bean.webBean.VRound;
import newthread.votesystem.bean.webBean.VoteInfo;
import newthread.votesystem.service.ProjectService;
import newthread.votesystem.service.RoundService;
import newthread.votesystem.service.SessionService;
import newthread.votesystem.service.UserService;
import newthread.votesystem.utils.WebUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 一个糟老头子
 * @createDate 2019/7/17-15:36
 */
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    ProjectService projectService;

    @Autowired
    SessionService sessionService;

    @Autowired
    RoundService roundService;

    /**
     * 查询用户参与投票的轮次信息
     *
     * @param user(userId)
     * @return 当前用户可以投票的轮次信息
     */
    @RequestMapping("/getUserVoteInfo")
    @ResponseBody
    public VRound getUserVoteInfo(@RequestBody User user) {
        List<UserVoteInfo> list = userService.queryAll(user.getUserId());
        List<UserVoteInfo> before = new ArrayList<>();
        List<UserVoteInfo> being = new ArrayList<>();
        List<UserVoteInfo> after = new ArrayList<>();
        for (UserVoteInfo userVoteInfo : list) {
            if (userVoteInfo.getRoundState() == 1) {
                before.add(userVoteInfo);
            } else if (userVoteInfo.getRoundState() == 2) {
                being.add(userVoteInfo);
            } else {
                after.add(userVoteInfo);
            }
        }
        VRound vRound = new VRound();
        vRound.setBefore(before);
        vRound.setBeing(being);
        vRound.setAfter(after);
        return vRound;
    }

    /**
     * 2.1投票点击开始时
     *
     * @param srUid
     * @return
     */
    @RequestMapping("/getVoteInfo")
    @ResponseBody
    public VoteInfo getVoteInfo(@RequestBody SRUid srUid) {
        //是否有他投票权限
        boolean haveAuthority = userService.judgeAuthority(srUid.getUserId(), srUid.getSessionId());
        //是否已经投票
        boolean isVote = userService.judeVote(srUid.getUserId(), srUid.getSessionId(), srUid.getRoundId());
        String voteType = sessionService.getSessionBySessionId(srUid.getSessionId()).getVoteType();
        VoteInfo voteInfo = new VoteInfo();
        Round round = roundService.queryRound(srUid.getRoundId());
        Integer upLimit = round.getUpLimit();
        if (voteType.equals("V")||voteType.equals("v")) {
            voteInfo.setUpLimit(upLimit);
        }
        voteInfo.setVoteRule(round.getVoteRule());
        //要投票的项目
        List<Project> projects = projectService.queryAllProjectsByRoundId(srUid.getSessionId(), srUid.getRoundId());
        voteInfo.setVote(isVote);
        voteInfo.setHaveAuthority(haveAuthority);
        voteInfo.setProjects(projects);
        voteInfo.setVoteType(voteType);
        return voteInfo;
    }

    /**
     * 下载项目文件
     * @param projectId
     * @return
     */
    @RequestMapping("/getProjectFile")
    //@ResponseBody
    public ResponseEntity<byte[]> downProjectFile(@RequestParam("projectId") Integer projectId) throws IOException {
        System.out.println(projectId);
        //获得文件
        byte[] bytes = projectService.downLoadProjectFile(projectId);
        HttpHeaders headers = new HttpHeaders();
        //用项目名称作为文件名
        String fileName = projectService.getProjectFileName(projectId);
        //设置编码格式
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //fileName.getBytes("UTF-8");
        //headers.setContentDispositionFormData("attachment",fileName);
        //二进制下载文件
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //处理乱码问题
        headers.add("Content-Disposition", "attachment;fileName=" + downloadFielName);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.ACCEPTED);
    }

    @RequestMapping("/getUserIdAndUserPassword")
    public ResponseEntity<byte[]> getUserIdAndUserPassword() throws UnsupportedEncodingException {
        byte[] bytes = ExcelExportUtil.exportToBytes(userService.getAllUsers());
        HttpHeaders headers = new HttpHeaders();
        //用项目名称作为文件名
        String fileName = "用户名及密码.xls";
        //设置编码格式
        String downloadFielName = new String(fileName.getBytes("utf-8"),"iso-8859-1");
        //fileName.getBytes("UTF-8");
        //headers.setContentDispositionFormData("attachment",fileName);
        //二进制下载文件
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        //处理乱码问题
        headers.add("Content-Disposition", "attachment;fileName=" + downloadFielName);
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.ACCEPTED);
    }
    /**
     * 提交投票结果
     *
     * @param results
     * @return
     */
    @RequestMapping("/addResult")
    @ResponseBody
    public boolean addResult(@RequestBody List<Result> results) {
        return userService.addVoteResult(results);
    }

}
