package mx.itc.shopall.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import mx.itc.shopall.model.Usuario;

@Component
public class JsonUtils {
    private static final Logger LOGGER  = LoggerFactory.getLogger(JsonUtils.class);

    public String jsonUser(Usuario usuario){
        Gson gson = new Gson();
        LOGGER.info(gson.toJson(usuario));
        return gson.toJson(usuario);
    }

    public Usuario objectUsuario(String json){
        Gson gson = new Gson();
        return gson.fromJson(json, Usuario.class);
    }
}
