package junit.test;

import java.util.Date;
import java.util.List;

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
import com.silence.questionlib.utils.WebUtils;

public class DaoTest {

	@Test
	public void testStudent() {

		Teacher teacher = new Teacher();
		// teacher.setCollege("信息学院");
		teacher.setEmail("102123@qq.com");
		teacher.setPassword("123");
		teacher.setPhone("110");
		teacher.setRegisterTime(new Date());
		teacher.setTeaid("232421425");
		teacher.setTeaname("老师1");

		TeacherDao teacherDao = new TeacherDaoImpl();
		teacherDao.addTeacher(teacher);

		Group group = new Group();
		group.setCollege("信息学院");
		group.setGroupname("计算机4班");
		group.setTeaid("232421422");
		group.setGroupid(WebUtils.getUUID());

		teacherDao.addGroup(group);

	}

	@Test
	public void testAddStudet() {
		Student student = new Student();
		student.setCollege("信息学院");
		student.setEmail("10981297912@qq.com");
		student.setGroupid("600e5f75-0d01-412b-92a9-f8752019070d");
		student.setPassword("123456");
		student.setPhone("13210135013");
		student.setRegisterTime(new Date());
		student.setStuid("201301050417");
		student.setStuname("林宇强");

		StudentDao studentDao = new StudentDaoImpl();
		studentDao.addStudent(student);
	}

	@Test
	public void testStudentLogin() {
		StudentDao dao = new StudentDaoImpl();
		Student student = dao.findStudent("201301050415");
		System.out.println(student);
	}

	@Test
	public void testCreateGroup() {
		TeacherDao dao = new TeacherDaoImpl();
		Group group = new Group();
		group.setCollege("信息学院");
		group.setGroupname("计算机4班");
		group.setTeaid("232421422");
		group.setGroupid(WebUtils.getUUID());

		dao.addGroup(group);
	}

	@Test
	public void testGroupStudent() {
		TeacherDao dao = new TeacherDaoImpl();
		List<Student> students = dao
				.findGroupStudents("297e1e39517197f001517197f4ce0000");
		for (Student student : students)
			System.out.println(student);
	}

	@Test
	public void testFindGroups() {
		TeacherDao dao = new TeacherDaoImpl();
		List<Group> groups = dao.findGroups("12345678");
		System.out.println(groups);
	}

	@Test
	public void testTeacherLogin() {
		TeacherDao dao = new TeacherDaoImpl();
		Teacher teacher = dao.findTeacher("232421422");
		System.out.println(teacher);
	}

	@Test
	public void testGetPaper() {
		QuestionDao dao = new QuestionDaoImpl();
		List<Question> questions = dao
				.findPaperQuestions("297e1e395171a944015171a948f90000");
		System.out.println(questions);
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
	public void testAddQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
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

		dao.addQuestion(question);
	}

	@Test
	public void testUpdateQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
		Question question = new Question();
		question.setInsertTime(new Date());
		question.setOther1("other1");
		question.setOther2("other2");
		question.setOther3("other3");
		question.setOther4("other4");
		question.setOwnerid("12345678");
		question.setQuesanswer("答案---->>修改");
		question.setQuescontent("内容");
		question.setQuesid("f45676c9-dd00-4a01-a1e0-8fd25714677d");
		question.setQuesname("标题");
		question.setQuestype("xuanze");

		dao.updateQuestion(question);
	}

	@Test
	public void testDeleteQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
		dao.deleteQuestion("f45676c9-dd00-4a01-a1e0-8fd25714677d");
	}

	@Test
	public void testFindPaper() {
		QuestionDao dao = new QuestionDaoImpl();
		Paper paper = dao.findPaper("04b1dada-a5f0-49fa-9b88-6c2bf1a7d32b");
		System.out.println(paper);
	}

	@Test
	public void testFindStudentPapers() {
		QuestionDao dao = new QuestionDaoImpl();
		List<Paper> papers = dao.findStudentPapers("201301050411");
		for (Paper paper : papers)
			System.out.println(paper);
	}

	@Test
	public void testFindPaperQuestion() {
		QuestionDao dao = new QuestionDaoImpl();
		List<Question> questions = dao
				.findPaperQuestions("04b1dada-a5f0-49fa-9b88-6c2bf1a7d32b");
		for (Question question : questions)
			System.out.println(question);
	}
}
