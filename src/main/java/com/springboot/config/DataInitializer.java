package com.springboot.config;

import com.springboot.domain.Book;
import com.springboot.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.Arrays;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(BookRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                Book book1 = new Book();
                book1.setBookId("ISBN1234");
                book1.setName("HTML5+CSS3");
                book1.setUnitPrice(new BigDecimal("27000"));
                book1.setAuthor("황재호");
                book1.setDescription("HTML5+CSS3의 기초부터 실무 수준의 응용 기술까지 다룹니다.");
                book1.setPublisher("한빛아카데미");
                book1.setCategory("IT전문서");
                book1.setUnitsInStock(1000);
                book1.setReleaseDate("2023/10/01");
                book1.setCondition("New");
                book1.setFilename("ISBN1234.jpg");

                Book book2 = new Book();
                book2.setBookId("ISBN1235");
                book2.setName("자바스크립트 입문");
                book2.setUnitPrice(new BigDecimal("28000"));
                book2.setAuthor("이지훈");
                book2.setDescription("자바스크립트의 핵심 기초부터 실전 예제까지 쉽게 설명합니다.");
                book2.setPublisher("이지스퍼블리싱");
                book2.setCategory("IT전문서");
                book2.setUnitsInStock(500);
                book2.setReleaseDate("2024/01/15");
                book2.setCondition("New");
                book2.setFilename("ISBN1235.jpg");

                Book book3 = new Book();
                book3.setBookId("ISBN1236");
                book3.setName("Spring Boot 실전");
                book3.setUnitPrice(new BigDecimal("32000"));
                book3.setAuthor("김철수");
                book3.setDescription("스프링 부트로 실전 웹 애플리케이션을 구축하는 방법을 배웁니다.");
                book3.setPublisher("위키북스");
                book3.setCategory("IT전문서");
                book3.setUnitsInStock(300);
                book3.setReleaseDate("2024/02/20");
                book3.setCondition("Refurbished");
                book3.setFilename("ISBN1236.jpg");

                repository.saveAll(Arrays.asList(book1, book2, book3));
                System.out.println("기본 도서 데이터가 초기화되었습니다.");
            }
        };
    }
}
