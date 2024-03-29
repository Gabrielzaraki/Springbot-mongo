package com.work.demo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.work.demo.DTO.AuthorDTO;
import com.work.demo.DTO.CommentDTO;
import com.work.demo.domain.Post;
import com.work.demo.domain.User;
import com.work.demo.repository.PostRepository;
import com.work.demo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		userRepository.deleteAll();
		postRepository.deleteAll();
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Ihaaa", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("25/03/2018"), "Vamos nessa!", "Quero curtir tbm", new AuthorDTO(maria));
		
		CommentDTO c1 = new CommentDTO("Lindo", sdf.parse("21/03/2018)"), new AuthorDTO(alex));
		
		
		postRepository.saveAll(Arrays.asList(post1,post2));
		
		post1.setComments(Arrays.asList(c1));
		
		postRepository.saveAll(Arrays.asList(post1));
		
		maria.getPosts().addAll(Arrays.asList(post1,post2));
		userRepository.save(maria);
	}
	

}
