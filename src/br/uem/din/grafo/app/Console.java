/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uem.din.grafo.app;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author luiz.pereira
 */
public class Console {
    public final static void limparConsole() {
        try {
            Robot robot = new Robot();
            robot.setAutoDelay(10);
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyRelease(KeyEvent.VK_L);
        } catch (AWTException ex) {
            JOptionPane.showMessageDialog(null, "Falha ao limpar console!\nErro: ".concat(ex.getMessage().trim()), "Falha ao limpar console", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int showMenu() {
        Scanner in = new Scanner(System.in);    
        System.out.println("------------- Menu do Sistema GrafoTec --------------");
        System.out.println("|    01) Criar Grafo                                |");
        System.out.println("|    02) Imprimir Grafo Completo                    |");
        System.out.println("|    03) Imprimir Arestas - Detalhado               |");
        System.out.println("|    04) Imprimir Vertices - Detalhado              |");
        System.out.println("|    05) Ordenar Arestas                            |");
        System.out.println("|    06) Resetar Grafo                              |");
        System.out.println("|---------------------------------------------------|");
        System.out.println("|    07) Criar MST                                  |");
        System.out.println("|    08) Imprimir MST Completa                      |");
        System.out.println("|    09) Imprimir Arestas da MST - Detalhado        |");
        System.out.println("|    10) Resetar MST                                |");
        System.out.println("|    11) Listar Agrupamentos da MST                 |");
        System.out.println("|    00) Sair                                       |");
        System.out.println("-----------------------------------------------------");
        System.out.print("Opcao: "); 
        return in.nextInt();  
    }
}
