package nvelasquez.pruebaCtrl;


import nvelasquez.pruebaImp.BuscarBinario;

import java.io.IOException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class BuscarBinarioController {

    @RequestMapping(value="/buscarBinario/{id}" , method = RequestMethod.GET)
    public void postMethodName(@PathVariable("id") int id) throws IOException {
        //TODO: process POST request
        
        new BuscarBinario().buscarNumero(id);

    }
    
    
}
