import com.pengrad.telegrambot.model.Chat;

import java.util.ArrayList;

public class Usuario {
    private static Chat chat;
    private static int status;
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

    public static Chat getChat() {
        return chat;
    }

    public static void setChat(Chat chat) {
        Usuario.chat = chat;
    }

    public static int getStatus() {
        return status;
    }

    public static void setStatus(int status) {
        Usuario.status = status;
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

        System.out.println("Usuário " + chat.id() + " não encontrado. Adicionando como novo usuário");
        Usuario newUser = new Usuario(chat, STATUS_NEW_USER);
        usuarios.add(newUser);
        return newUser;
    }
}
