import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Chat;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ReplyKeyboardRemove;
import com.pengrad.telegrambot.request.SendMessage;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class MeuContadorBot {
    TelegramBot bot;
    ArrayList<Usuario> users = new ArrayList<>();

    public MeuContadorBot() {
        bot = new TelegramBot(Constants.BOT_TOKEN);
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if(update.message() == null){
                    System.out.println("Update sem mensagem - ignorando: " + update.updateId());
                    continue;
                }
                String texto = update.message().text();
                Chat chat = update.message().chat();

                Usuario user = Usuario.getUsuarioByChat(users, chat);

                switch (user.getStatus()) {
                    case Usuario.STATUS_NEW_USER:
                        bot.execute(new SendMessage(user.getChat().id(), TextMessages.HELLO_IM_TRON).replyMarkup(new ReplyKeyboardRemove()));
                        user.setStatus(Usuario.STATUS_WAITING_WAGE);
                        break;
                    case Usuario.STATUS_WAITING_WAGE:
                        try {
                            double wage = Double.parseDouble(texto.replaceAll(",", "."));
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ASK_FOR_DISCOUNT));
                            user.setWage(wage);
                            user.setStatus(Usuario.STATUS_WAITING_DISCOUNT);
                        } catch (NumberFormatException e) {
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ERROR_MESSAGE_INVALID_WAGE));
                        }
                        break;
                    case Usuario.STATUS_WAITING_DISCOUNT:
                        try {
                            double discount = Double.parseDouble(texto.replaceAll(",", "."));
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ASK_WHAT_TO_DO).replyMarkup(TextMessages.getTecladoMenuInicial()));
                            user.setDiscount(discount);
                            user.setStatus(Usuario.STATUS_ANSWER_MENU);
                        } catch (NumberFormatException e) {
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ERROR_MESSAGE_INVALID_DISCOUNT));
                        }
                        break;
                    case Usuario.STATUS_ANSWER_MENU:
                        if(texto.equals(TextMessages.LIQUID_WAGE)){
                            if (user.getWage() <= 1100){
                                double inss = user.getWage() * 0.075;
                                if (user.getWage() <= 1903.98){
                                    double ir = 0;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                            }
                            else if (user.getWage() <= 2203.48 && user.getWage() >= 1100.01){
                                double inss = (user.getWage() * 0.09) - 16.50;
                                if (user.getWage() <= 2826.65 && user.getWage() >= 1903.99){
                                    double ir = ((user.getWage() - inss) * 0.075) - 142.80;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                            }
                            else if(user.getWage() <= 3305.22 && user.getWage() >= 2203.49){
                                double inss = (user.getWage() * 0.12) - 82.60;
                                if (user.getWage() <= 2826.65 && user.getWage() >= 2203.49){
                                    double ir = ((user.getWage() - inss) * 0.075) - 142.80;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                                else if (user.getWage() <= 3305.22 && user.getWage() >= 2826.66){
                                    double ir = ((user.getWage() - inss) * 0.15) - 354.80;
                                    System.out.println(ir);
                                    System.out.println(inss);
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                            }
                            else if (user.getWage() <= 6433.57 && user.getWage() >= 3305.23){
                                double inss = (user.getWage() * 0.14) - 148.71;
                                if (user.getWage() <= 3751.05 && user.getWage() >= 3305.23){
                                    double ir = ((user.getWage() - inss) * 0.15) - 354.80;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                                else if (user.getWage() <= 4664.68 && user.getWage() >= 3751.06){
                                    double ir = ((user.getWage() - inss) * 0.225) - 636.13;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                                else{
                                    double ir = ((user.getWage() - inss) * 0.275) - 869.36;
                                    double final_wage = user.getWage() - inss - ir - user.getDiscount();
                                    double final_tax = inss + ir;
                                    DecimalFormat f = new DecimalFormat("#.##");

                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                    bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                                }
                            }else{
                                double ir = ((user.getWage() - 751.99) * 0.275) - 869.36;
                                double final_wage = user.getWage() - 751.99 - ir - user.getDiscount();
                                double final_tax = 751.99 + ir;
                                DecimalFormat f = new DecimalFormat("#.##");

                                bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_TAX + f.format(final_tax)));
                                bot.execute(new SendMessage(user.getChat().id(), TextMessages.FINAL_WAGE + f.format(final_wage)));
                            }

                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ASK_WHAT_TO_DO).replyMarkup(TextMessages.getTecladoMenuFinal()));
                        }else if(texto.equals(TextMessages.INCOME_TAX)){
                            if (user.getWage() >= 1903.98){
                                bot.execute(new SendMessage(user.getChat().id(), TextMessages.INCOME_TAX_MESSAGE).replyMarkup(TextMessages.getTecladoMenuFinal()));
                            }else {
                                bot.execute(new SendMessage(user.getChat().id(), TextMessages.NO_INCOME_TAX_MESSAGE).replyMarkup(TextMessages.getTecladoMenuFinal()));
                            }
                        }else if(texto.equals(TextMessages.ABOUT)){
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.ABOUT_MESSAGE));
                        }else if(texto.equals(TextMessages.CLOSE)){
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.CLOSE_MESSAGE).replyMarkup(new ReplyKeyboardRemove()));
                            users.remove(user);
                        }else{
                            // mensagem padrão
                            bot.execute(new SendMessage(user.getChat().id(), TextMessages.DEFAULT_ERROR_MESSAGE));
                        }
                        break;
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }


    public static void main(String[] args) {
        new MeuContadorBot();
    }
}
