package chatmodule;

import chatmodule.bean.Group;
import chatmodule.bean.GroupMember;
import chatmodule.bean.GroupMessage;
import chatmodule.service.GroupMemberService;
import chatmodule.service.GroupMessageService;
import chatmodule.service.GroupService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class ChatmoduleApplicationTests {
    @Autowired
    GroupService groupService;
    @Autowired
    GroupMemberService groupMemberService;
    @Autowired
    GroupMessageService groupMessageService;
    @Test
    void contextLoads() {
    }

    @Test
    void testGroupInsert() throws ParseException {
        Timestamp  ts=new Timestamp(new Date().getTime());
        System.out.println(ts.toString());
        Group group = new Group(2,"dev群",ts.toString(),"dev","dev","dev","dev","dev","dev");
        groupService.createGroup(group);
    }

    @Test
    void testGroupDelete(){
        groupService.deleteGroup(1);
    }

    @Test
    void testGroupUpdate(){
        Timestamp  ts=new Timestamp(new Date().getTime());
        Group group = new Group(2,"dev群",ts.toString(),"dev","dev","dev","dev","dev","dev");
        group.setGrpName("update");
        groupService.modifyGroupInfo(group);
    }

    @Test
    void testGroupMemberAdd(){
        GroupMember groupMember = new GroupMember("lzc",1,"管理");
        groupMemberService.addMember(groupMember);
    }

    @Test
    void testGroupMember(){
        groupMemberService.deleteMember("lzc");
    }

    @Test
    void testGroupMessage(){
        Timestamp  ts=new Timestamp(new Date().getTime());
        GroupMessage message = new GroupMessage(1,2,"lzc","测试群聊",ts);
        groupMessageService.addOneMessage(message);
    }

    @Test
    void testGroupMessageRemove(){
        groupMessageService.removeMessage(1);
    }

}
