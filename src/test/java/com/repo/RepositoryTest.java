package com.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.bean.Author;
import com.bean.Book;
import com.bean.UserPO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext-persist.xml" })
public class RepositoryTest {

	private Logger log = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void userRepositoryTest() {

		List<UserPO> poList = userRepository.findAll();
		log.info("poList size = [{}] ", poList.size());

	}

	@Test
	public void findBookTest() {
		List<Book> bookList = bookRepository.findAll();
		log.info("bookList size = [{}] ", bookList.size());
	}

	@Test
	public void findAuthorTest() {
		List<Author> authorList = authorRepository.findAll();
		for(Author author : authorList){
			System.out.println(author.getBooks().size());
		}
		log.info("authorList size = [{}] ", authorList.size());

	}
	
	@Test
	private void TestJdbcTemplate(){
		
		jdbcTemplate.execute("");
		
	}

}
