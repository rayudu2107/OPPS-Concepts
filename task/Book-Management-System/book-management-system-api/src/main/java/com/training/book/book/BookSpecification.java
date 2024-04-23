package com.training.book.book;

import org.springframework.data.jpa.domain.Specification;

import com.training.book.entity.Book;

public class BookSpecification {

    public static Specification<Book> withOwnerId(Integer ownerId) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("owner").get("id"), ownerId);
    }
}
