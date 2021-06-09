import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;

public class TextMessages {
    public static final String HELLO_IM_TRON = "Olá, eu sou o Tron, o seu assistente virtual. Eu posso ajudar você a entender melhor quais descontos serão feitos ao seu salário.\n \n" +
            "Para começar, peço que digite seu salário, de forma numérica e utilizando apenas o vírgula para identificar os centavos";
    public static final String ERROR_MESSAGE_INVALID_WAGE = "Não entendi. Por favor envie somente o valor do salário de forma numérica e utilizando apenas o vírgula para identificar os centavos";
    public static final String ASK_FOR_DISCOUNT = "Digite também o valor de outros descontos, como por exemplo: plano de saúde, vale refeição, transporte e etc";
    public static final String ERROR_MESSAGE_INVALID_DISCOUNT = "Não entendi. Por favor envie somente o valor dos descontos de forma numérica e utilizando apenas o vírgula para identificar os centavos";
    public static final String ASK_WHAT_TO_DO = "Selecione uma das opções abaixo";
    public static final String LIQUID_WAGE = "Qual será meu salário liquido?";
    public static final String INCOME_TAX = "Preciso pagar Imposto de Renda?";
    public static final String ABOUT = "Saber mais sobre o chatbot";
    public static final String CLOSE = "Finalizar conversa";
    public static final String FINAL_TAX = "Serão descontados do seu salário em impostos R$ ";
    public static final String FINAL_WAGE = "Sendo assim, seu salário final será de R$ ";
    public static final String INCOME_TAX_MESSAGE = "Por possuir um salário maior que R$ 1.903,98, terá sim " +
            "que pagar Imposto de Renda";
    public static final String NO_INCOME_TAX_MESSAGE = "Por possuir um salário menor que R$ 1.903,98, você não " +
            "terá que pagar Imposto de Renda";
    public static final String CLOSE_MESSAGE = "Agradeço pelo seu contato e espero ter te ajudado de alguma forma.\n" +
            "E já sabe né? Qualquer dúvida pode me chamar que estarei à sua disposição";
    public static final String ABOUT_MESSAGE = "Legal! Adoro gente que gosta de aprender.\n" +
            "Sobre chatbots: Somos um programa de computador com intuito de simular um ser humano enquanto conversamos. O objetivo é responder as perguntas de tal forma que as " +
            "pessoas tenham a impressão de estar conversando com outra pessoa e assim otimizamos tempo dos nossos " +
            "técnicos humanos e de nossos clientes finais.\n \n" +
            "Especificamente sobre mim: Eu sou um assistente virtual que tem como objetivo te auxiliar no entendimento de " +
            "quais serão os possíveis impostos que serão descontados em sua folha salarial.";


    public static ReplyKeyboardMarkup getTecladoMenuInicial() {
        String[][] teclado = {
                {LIQUID_WAGE},
                {INCOME_TAX},
                {ABOUT},
        };

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(teclado);
        return markup;
    }

    public static ReplyKeyboardMarkup getTecladoMenuFinal() {
        String[][] teclado = {
                {LIQUID_WAGE},
                {INCOME_TAX},
                {ABOUT},
                {CLOSE},
        };

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(teclado);
        return markup;
    }
}

