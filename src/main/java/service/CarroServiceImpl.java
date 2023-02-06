package service;

import model.Carro;

public class CarroServiceImpl implements CarroService {
    @Override
    public void acelerar(Carro carro, int velocidadeAMais) {

            if (velocidadeAMais < 0) {
                velocidadeAMais = 0;
            }

            carro.setVelocidadeAtual(carro.getVelocidadeAtual() + velocidadeAMais);

            if (carro.getVelocidadeAtual() > carro.getVelocidadeMaxima()) {
                carro.setVelocidadeAtual(carro.getVelocidadeMaxima());
            } else if (carro.getVelocidadeAtual() <= 0) {
                carro.setVelocidadeAtual(0);
            } else if (carro.getVelocidadeAtual() > 0 && !carro.isLigado()){
                carro.setVelocidadeAtual(0);
            } else if (carro.getVelocidadeAtual() < 0 && !carro.isLigado()) {
                carro.setVelocidadeAtual(0);
            }

    }

    @Override
    public void frear(Carro carro, int velocidadeAMenos) {
        if (velocidadeAMenos < 0) {
            velocidadeAMenos = 0;
        }
        if((carro.getVelocidadeAtual() - velocidadeAMenos) <= 0) {
            carro.setVelocidadeAtual(0);
        } else {
            carro.setVelocidadeAtual(carro.getVelocidadeAtual() - velocidadeAMenos);
        }
        if (carro.getVelocidadeAtual() >= 0 && !carro.isLigado()) {
            carro.setVelocidadeAtual(0);
        }
    }

    @Override
    public void ligar(Carro carro) {
        carro.setLigado(true);
    }

    @Override
    public void desligar(Carro carro) {
        if (carro.getVelocidadeAtual() > 0) {
            carro.setVelocidadeAtual(0);
            carro.setLigado(false);
        } else {
            carro.setVelocidadeAtual(0);
            carro.setLigado(false);
        }

    }

    @Override
    public String estadoAtual(Carro carro) {
        return carro.toString();
    }
}