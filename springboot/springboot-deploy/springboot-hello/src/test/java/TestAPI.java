import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.PullResult;
import org.eclipse.jgit.internal.storage.file.FileRepository;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.transport.UsernamePasswordCredentialsProvider;
import org.example.HelloWorldMainApplication;
import org.example.controller.GitController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = HelloWorldMainApplication.class)
public class TestAPI {

    private static final Logger logger = LoggerFactory.getLogger(GitController.class);
    private Git git;
    private Repository localRepo;


    private String GitUrl = "https://gitlab.bingosoft.net/app-factory-metadata/vcjNCsQErFvPAJg5p5KKkP.git";
    private String BranchName = "master";

    private String LocalRootPath= "./repo";

    private String GitUserName = "linkfactory";

    private String GitPassword = "factory_2019";



    @Test
    public void GitSync(){
        logger.info("Git Sync: start..."+getCurrentTime());
        boolean isSuccess = false;

        UsernamePasswordCredentialsProvider credentialsProvider = new UsernamePasswordCredentialsProvider(
                GitUserName,GitPassword);
        try {
            logger.info("============localPath==========" + getLocalPath());
            localRepo = new FileRepository(getLocalPath() + "/.git");
            git = new Git(localRepo);
            File localPathFile = new File(getLocalPath());
            if (!localPathFile.exists()) {
                Git git = GitClone(GitUrl, BranchName, getLocalPath(),credentialsProvider);
                if (git != null){
                    isSuccess = true;
                }
            } else {
                isSuccess = GitPull(BranchName,credentialsProvider);
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
            e.printStackTrace();
            logger.info("Git Sync: end..."+getCurrentTime());
            return;
        }finally{
            logger.info("Git Sync: end..."+getCurrentTime());
        }

        if (isSuccess)
            return;
        return;
    }

    /**
     * 获取本地路径
     * @return
     */
    private String getLocalPath(){
        return ".repo";
    }

    /**
     * 获取当前时间
     * @return
     */
    private String getCurrentTime(){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    /**
     * 执行GitClone
     */
    private Git GitClone(String gitUrl, String branch, String localPath, UsernamePasswordCredentialsProvider credentialsProvider) throws Exception {
        return Git.cloneRepository().setURI(gitUrl).setBranch(branch).setDirectory(new File(localPath)).setCredentialsProvider(credentialsProvider).call();
    }

    /**
     * 执行GitPull
     */
    private boolean GitPull(String branch,UsernamePasswordCredentialsProvider credentialsProvider) throws Exception {
        // 强制stash 保证不会冲突
        git.stashCreate();

        //TODO 更多命令
        //git.pull();
        //git.add();
        //git.push();
        //git.merge();

        PullResult result = git.pull().setRemoteBranchName(branch).setCredentialsProvider(credentialsProvider).call();
        return result.isSuccessful();
    }
}
