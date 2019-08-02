package parser;


import parser.massParser.AliexpressMassParser;


public class Main {
    public static void main(String[] args)  {
        AliexpressMassParser aliexpressMassParser= new AliexpressMassParser();
        //every +1 to mass parse give us +12 products. See ConnectorToAliexpress;
        aliexpressMassParser.massParse(9);




    }
}