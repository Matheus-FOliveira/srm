package matheus.ferraz.srm.controllers;

import matheus.ferraz.srm.services.MoedaService;

public class MoedaController {
    private final MoedaService moedaService;

    public MoedaController(MoedaService moedaService) {
        this.moedaService = moedaService;
    }


}
