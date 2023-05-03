package com.entidade;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Controla o Voo.
 *
 * @author osmar
 */
public class ControladorVooImpl implements ControladorVoo {

    private static ArrayList<Voo> voos = new ArrayList<>();
    public final int NUMERO_DE_VOOS = 10;

    public ControladorVooImpl() {
        for (int numero = 1; numero <= NUMERO_DE_VOOS; numero++) {
            String codigoVoo = "A" + numero;
            Voo voo = new Voo(codigoVoo);
            voos.add(voo);
        }
    }

    /**
     * Método remoto para verificar o status.
     *
     * @param codigoVoo
     * @param numeroAssento
     * @return
     * @throws java.rmi.RemoteException
     */
    @Override
    public int verificarStatus(String codigoVoo, int numeroAssento) throws RemoteException {
        // Procura o código do voo
        Voo voo = procurarVoo(codigoVoo);
        if (voo == null) {
            return 3; //Voo inexistente
        }
        //Procura o assento no voo
        Assento assento = voo.procurarAssento(numeroAssento);
        if (assento == null) {
            return 2; //Assento inexistente
        }
        //Verifica se o assento está disponível
        if (!assento.getDisponivel()) {
            return 1; //Assento indisponível
        }
        return 0; //Voo e assento disponível
    }

    /**
     * Método remoto para marcar o voo e o assento.
     *
     * @param codigoVoo
     * @param numeroAssento
     * @return
     * @throws java.rmi.RemoteException
     */
    @Override
    public int marcarVoo(String codigoVoo, int numeroAssento) throws RemoteException {
        // Se o voo não foi encontrado , codigo de erro 3
        Voo voo = procurarVoo(codigoVoo);
        if (voo != null) {
            Assento assento = voo.procurarAssento(numeroAssento);
            if (assento != null) {
                if (assento.getDisponivel()) {
                    assento.setDisponivel(false);
                    return 4; //Assento marcado
                }
            }
        }
        return 0;
    }

    /**
     * Procura o código do voo.
     *
     * @param codigoVoo
     * @return
     */
    public Voo procurarVoo(String codigoVoo) {
        // procura o voo enviado , se nada for encontrado, retorna null  {
        for (Voo v : voos) {
            // Verifica se o codigo bate com o que foi procurado
            if (v.getCodigoVoo().equals(codigoVoo)) {
                return v;
            }
        }
        return null;
    }
}
