import com.pengrad.telegrambot.model.Chat;

import java.util.ArrayList;

public class Usuario {
    private Chat chat;
    private int status;
    private double wage;
    private double discount;

    public static final int  STATUS_NEW_USER = 1;
    public static final int  STATUS_WAITING_WAGE = 2;
    public static final int  STATUS_WAITING_DISCOUNT = 3;
    public static final int  STATUS_ANSWER_MENU = 7;


    public Usuario(Chat chat, int status) {
        this.setChat(chat);
        this.setStatus(status);
    }

    public Chat getChat() {
        return chat;
    }

    public void setChat(Chat chat) {
        this.chat = chat;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public static Usuario getUsuarioByChat(ArrayList<Usuario> usuarios, Chat chat) {
        for (Usuario u : usuarios) {
            if (u.getChat().id().equals(chat.id())) {
                return u;
            }
        }

        System.out.println("Usuário " + chat.id() + " ("+chat.firstName() + " " + chat.lastName()+") não encontrado. Adicionando como novo usuário");
        Usuario newUser = new Usuario(chat, STATUS_NEW_USER);
        usuarios.add(newUser);
        return newUser;
    }
}
