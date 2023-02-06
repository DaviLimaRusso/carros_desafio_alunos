package service;

import model.Carro;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CarroServiceTest {

    CarroService carroService;

    @Before
    public void setup() {
        carroService = new CarroServiceImpl();
    }

    @Test
    public void deveAcelerarCorretamente() {
        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);


        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 10);

        // Então
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(10, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (deveAcelerarCorretamente): " + carro.getVelocidadeAtual());
    }

    @Test
    public void deveFrearCorretamente() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);


        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 90);
        carroService.frear(carro, 50);

        // Então
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(40, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual: " + carro.getVelocidadeAtual());
    }

    @Test
    public void naoDevePassarDaVelocidadeMaxima() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 190);


        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 100);
        carroService.acelerar(carro, 100);

        // Então
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(190, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (naoDevePassarDaVelocidadeMaxima): " + carro.getVelocidadeAtual());
    }

    @Test
    public void velocidadeNaoDeveSerMenorQueZero() {

        // Dado:
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);


        // Quando:
        carroService.ligar(carro);
        carroService.frear(carro, 10);

        // Então:
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(0, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (velocidadeNaoDeveSerMenorQueZero): " + carro.getVelocidadeAtual());
    }

    @Test
    public void deveLigarCorretamente() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);

        // Quando
        carroService.ligar(carro);

        // Então
        Assert.assertTrue(carro.isLigado());
        System.out.println("Carro está ligado?: " + carro.isLigado());
    }

    @Test
    public void umCarroDeveIniciarDesligado() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);

        // Quando
        carroService.acelerar(carro, 200);
        carroService.acelerar(carro, 30);
        carroService.frear(carro, 10);

        // Então
        Assert.assertFalse(carro.isLigado());
        Assert.assertEquals(0, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (umCarroDeveIniciarDesligado): " + carro.getVelocidadeAtual());
    }

    @Test
    public void umCarroDeveDesligarApenasParado() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);

        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 100);
        carroService.frear(carro, 50);
        carroService.desligar(carro);

        // Então
        Assert.assertFalse(carro.isLigado());
        System.out.println("Velocidade atual teste (umCarroDeveDesligarApenasParado): " + carro.getVelocidadeAtual());
        System.out.println("Carro está ligado?: " + carro.isLigado());
    }

    @Test
    public void frearComValorNegativo() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);

        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, 90);
        carroService.frear(carro, -10);

        // Então
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(90, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (frearComValorNegativo): " + carro.getVelocidadeAtual());
    }

    @Test
    public void naoDeveAcelerarComValorNegativo() {

        // Dado
        Carro carro = new Carro ("azul", "fiat", "uno", 2020, 100);

        // Quando
        carroService.ligar(carro);
        carroService.acelerar(carro, -90);
        carroService.acelerar(carro, 20);

        // Então
        Assert.assertTrue(carro.isLigado());
        Assert.assertEquals(20, carro.getVelocidadeAtual());
        System.out.println("Velocidade atual teste (naoDeveAcelerarComValorNegativo): " + carro.getVelocidadeAtual());
    }

}
