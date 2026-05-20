package com.list.ecommerce.controller;

import com.list.ecommerce.DTOs.request.UsuarioRequest;
import com.list.ecommerce.DTOs.response.UsuarioResponse;
import com.list.ecommerce.service.PhotoService;
import com.list.ecommerce.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;
    private final PhotoService photoService;

    public UsuarioController(UsuarioService usuarioService, PhotoService photoService) {
        this.usuarioService = usuarioService;
        this.photoService = photoService;
    }
    @PostMapping
    public ResponseEntity<?> criarUsuario(  @RequestParam UsuarioRequest usuarioRequest,
                                            @RequestParam MultipartFile photo) throws IOException {
        String pathPhoto = photoService.savePhoto(photo);
        return ResponseEntity.ok(usuarioService.criarUsuario(usuarioRequest, pathPhoto));
    }
    @PutMapping("/{id}")
    public UsuarioResponse atualizarUsuario(@RequestBody UsuarioRequest usuarioRequest,
                                            @PathVariable Integer id, @RequestParam MultipartFile photo) throws IOException {
        String pathPhoto = photoService.savePhoto(photo);
        return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuarioRequest, pathPhoto)).getBody();
    }
    @GetMapping("/{id}")
    public UsuarioResponse listarUsuarios(@PathVariable Integer id){

        return usuarioService.listarUsuarios(id);
    }
    @GetMapping
    public List<UsuarioResponse> listarTodosUsuarios(@PathVariable Integer id){
        return usuarioService.listarTodosUsuarios();
    }
    @DeleteMapping("/{id}")
    public void deletarUsuario(@PathVariable Integer id){
        usuarioService.deletarUsuario(id);
    }

}
