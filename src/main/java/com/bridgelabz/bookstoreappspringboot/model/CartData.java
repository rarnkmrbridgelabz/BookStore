package com.bridgelabz.bookstoreappspringboot.model;

import com.bridgelabz.bookstoreappspringboot.dto.CartDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
public class CartData {

    @Id
    @GeneratedValue
    private int cartId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "bookId")
    private BookData bookData;

    @OneToOne
    @JoinColumn(name = "userId")
    private UserRegistrationData userId;


    public CartData(BookData bookData, UserRegistrationData userRegistrationData, int quantity) {
        this.bookData = bookData;
        this.userId = userRegistrationData;
        this.quantity = quantity;
    }

    public void updateCartData(int cartId, String token, CartDTO cartDTO ) {
        this.quantity = cartDTO.quantity;
    }
}
