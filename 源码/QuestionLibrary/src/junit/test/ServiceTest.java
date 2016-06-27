package junit.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.silence.questionlib.dao.QuestionDao;
import com.silence.questionlib.dao.StudentDao;
import com.silence.questionlib.dao.TeacherDao;
import com.silence.questionlib.daoimpl.QuestionDaoImpl;
import com.silence.questionlib.daoimpl.StudentDaoImpl;
import com.silence.questionlib.daoimpl.TeacherDaoImpl;
import com.silence.questionlib.domain.Group;
import com.silence.questionlib.domain.Paper;
import com.silence.questionlib.domain.Question;
import com.silence.questionlib.domain.Student;
import com.silence.questionlib.domain.Teacher;
import com.silence.questionlib.exception.PaperNotExist;
import com.silence.questionlib.exception.QuestionNotExist;
import com.silence.questionlib.exception.QuestionUsedException;
import com.silence.questionlib.exception.StudentNotExist;
import com.silence.questionlib.exception.TeacherNotExist;
import com.silence.questionlib.service.QuestionLibService;
import com.silence.questionlib.service.StudentService;
import com.silence.questionlib.service.TeacherService;
import com.silence.questionlib.serviceimpl.QuestionLibServiceImpl;
import com.silence.questionlib.serviceimpl.StudentServiceImpl;
import com.silence.questionlib.serviceimpl.TeacherServiceImpl;
import com.silence.questionlib.utils.WebUtils;

public class ServiceTest {

	@Test
	public void testLoginStudent() throws StudentNotExist {
		StudentService service = new StudentServiceImpl();
		Student student = service.login("201301050411", "123456");
		System.out.println(student);
	}

	@Test
	public void testLoginTeacher() throws TeacherNotExist {
		TeacherService service = new TeacherServiceImpl();
		Teacher teacher = service.login("1", "123456");
		// Teacher teacher = service.login("12345678", "123456");
		System.out.println(teacher);
	}

	@Test
	public void testRegisterTeacher() {
		Teacher teacher = new Teacher();
		teacher.setCollege("信息学院");
		teacher.setEmail("102124@qq.com");
		teacher.setPassword("123");
		teacher.setPhone("110");
		teacher.setRegisterTime(new Date());
		teacher.setTeaid("232421426");
		teacher.setTeaname("老师1");

		TeacherService service = new TeacherServiceImpl();
		service.register(teacher);
	}

	@Test
	public void testCreateGroup() {
		TeacherService service = new TeacherServiceImpl();
		Group group = new Group();
		group.setCollege("信息学院");
		group.setGroupname("计算机4班");
		group.setTeaid("12345678");
		group.setGroupid(WebUtils.getUUID());

		service.createClass(group);
	}

	@Test
	public void testGroupStudent() {
		TeacherService service = new TeacherServiceImpl();
		List<Student> students = service
				.findGroupStudents("297e1e39517197f001517197f4ce0000");
		for (Student student : students)
			System.out.println(student);
	}

	@Test
	public void testFindGroups() {
		TeacherService service = new TeacherServiceImpl();
		List<Group> groups = service.findGroups("12345678");
		System.out.println(groups);
	}

	@Test
	public void testRegisterStudet() {
		Student student = new Student();
		student.setCollege("信息学院");
		student.setEmail("10981297913@qq.com");
		student.setGroupid("600e5f75-0d01-412b-92a9-f8752019070d");
		student.setPassword("123456");
		student.setPhone("13210135013");
		student.setRegisterTime(new Date());
		student.setStuid("201301050418");
		student.setStuname("林宇强");

		StudentService service = new StudentServiceImpl();
		service.register(student);
	}

	@Test
	public void testStudentLogin() throws StudentNotExist {
		StudentService service = new StudentServiceImpl();
		Student student = service.login("11", "123456");
		// Student student = service.login("201301050411", "123456");
		System.out.println(student);
	}

	@Test
	public void testQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
		Question question = dao
				.findQuestion("023e6816-8cea-4322-840b-5fadefaa5ce5");
		System.out.println(question);
	}

	@Test
	public void testQuestionType() {
		QuestionDao dao = new QuestionDaoImpl();
		List<Question> questions = dao.findQuestions("xuanze");
		for (Question question : questions)
			System.out.println(question);
	}

	@Test
	public void testAddQuestion1() {
		QuestionLibService service = new QuestionLibServiceImpl();
		Question question = new Question();
		question.setInsertTime(new Date());
		question.setOther1("other1");
		question.setOther2("other2");
		question.setOther3("other3");
		question.setOther4("other4");
		question.setOwnerid("12345678");
		question.setQuesanswer("答案");
		question.setQuescontent("内容");
		question.setQuesid(WebUtils.getUUID());
		question.setQuesname("标题");
		question.setQuestype("xuanze");
		service.addQuestion(question);
	}

	@Test
	public void testUpdateQuestion() throws QuestionNotExist {
		QuestionLibService service = new QuestionLibServiceImpl();
		Question question = new Question();
		question.setInsertTime(new Date());
		question.setOther1("other1");
		question.setOther2("other2");
		question.setOther3("other3");
		question.setOther4("other4");
		question.setOwnerid("12345678");
		question.setQuesanswer("答案---->>修改");
		question.setQuescontent("内容");
		question.setQuesid("f74ddabc-9be4-483d-80b2-751caa849b36");
		question.setQuesname("标题");
		question.setQuestype("xuanze");

		service.updateQuestion("f74ddabc-9be4-483d-80b2-751caa849b36", question);
	}

	@Test
	public void testDeleteQuestion() throws QuestionNotExist,
			QuestionUsedException {
		QuestionLibService service = new QuestionLibServiceImpl();
		service.deleteQuestion("f74ddabc-9be4-483d-80b2-751caa849b36");
	}

	@Test
	public void testFindPaper() throws PaperNotExist {
		QuestionLibService service = new QuestionLibServiceImpl();
		Paper paper = service
				.queryPaper("04b1dada-a5f0-49fa-9b88-6c2bf1a7d32b");
		System.out.println(paper);
	}

	@Test
	public void testFindStudentPapers() {
		QuestionLibService service = new QuestionLibServiceImpl();
		List<Paper> papers = service.findStudentPapers("201301050411");
		for (Paper paper : papers)
			System.out.println(paper);
	}

	@Test
	public void testFindPaperQuestion() throws QuestionNotExist {
		QuestionLibService service = new QuestionLibServiceImpl();
		List<Question> questions = service
				.queryPaperQuestions("04b1dada-a5f0-49fa-9b88-6c2bf1a7d32b");
		for (Question question : questions)
			System.out.println(question);
	}

	/**
	 * 测试添加问题
	 */
	@Test
	public void testAddQuestion() {
		QuestionLibService service = new QuestionLibServiceImpl();

		Question question = new Question();
		question.setInsertTime(new Date());
		question.setOwnerid("232421421");
		question.setOwnername("老师1");

		for (int i = 0; i < 20; i++) {
			question.setQuesid(WebUtils.getUUID());

			question.setQuescontent("名词解释题目内容" + (i + 1));
			question.setQuesname("名词解释标题" + (i + 1));
			question.setQuesanswer("名词解释答案" + (i + 1));
			question.setQuestype(Question.Type.jeishi);

			// question.setQuescontent("解答题目内容"+(i+1));
			// question.setQuesname("解答标题"+(i+1));
			// question.setQuesanswer("解答答案"+(i+1));
			// question.setQuestype(Question.Type.jianda);

			// question.setQuescontent("填空题目内容"+(i+1));
			// question.setQuesname("填空标题"+(i+1));
			// question.setQuesanswer("填空答案"+(i+1));
			// question.setQuestype(Question.Type.tiankong);

			// question.setQuescontent("应用题目内容"+(i+1));
			// question.setQuesname("应用标题"+(i+1));
			// question.setQuesanswer("应用答案"+(i+1));
			// question.setQuestype(Question.Type.yingyong);

			// question.setQuescontent("选择题目内容"+(i+1));
			// question.setQuesname("选择标题"+(i+1));
			// question.setQuesanswer("选择答案"+(i+1));
			// question.setOther1("A.选项A");
			// question.setOther2("B.选项B");
			// question.setOther3("C.选项C");
			// question.setOther4("D.选项D");
			// question.setQuestype(Question.Type.xuanze);

			service.addQuestion(question);
		}
	}

	/**
	 * 测试添加试卷
	 */
	@Test
	public void testAddPaper() {
		QuestionLibService service = new QuestionLibServiceImpl();

		Paper paper = new Paper();
		paper.setDestGroup("297e1e39517197f001517197f4ce0000");
		paper.setOwnerid("12345678");
		paper.setOwnername("崔阵雨");
		paper.setPaperid(WebUtils.getUUID());
		paper.setPapername("软件工程考试");
		paper.setPaperTime(new Date());
		List<String> quesids = new ArrayList<String>();// 题目id
		List<Float> qvalues = new ArrayList<Float>();// 题目总分
		
		List<Question> questions = service.getAll(Question.Type.xuanze);
		for(Question q:questions){
			quesids.add(q.getQuesid());
			qvalues.add(new Random().nextFloat());
		}
		
		questions = service.getAll(Question.Type.jeishi);
		for(Question q:questions){
			quesids.add(q.getQuesid());
			qvalues.add(new Random().nextFloat());
		}
		
		questions = service.getAll(Question.Type.jianda);
		for(Question q:questions){
			quesids.add(q.getQuesid());
			qvalues.add(new Random().nextFloat());
		}
		
		questions = service.getAll(Question.Type.tiankong);
		for(Question q:questions){
			quesids.add(q.getQuesid());
			qvalues.add(new Random().nextFloat());
		}
		
		questions = service.getAll(Question.Type.yingyong);
		for(Question q:questions){
			quesids.add(q.getQuesid());
			qvalues.add(new Random().nextFloat());
		}
		
		service.createPaper(paper, quesids, qvalues);
	}
}
