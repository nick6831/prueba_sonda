package nvelasquez.pruebaCtrl;


import nvelasquez.pruebaImp.BuscarBinario;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController

public class BuscarBinarioController {

    @RequestMapping(value="/buscarBinario" , method = RequestMethod.POST, produces = {"application/json"},consumes = MediaType.APPLICATION_JSON_VALUE)
    public String postMethodName(@RequestBody String id) throws IOException {
        
       JSONObject numero = new BuscarBinario().buscarNumero(id);
       return numero.toString();

    }
    
    
}
