package com.lds.aluguel_carros.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.lds.aluguel_carros.entity.Usuario;
import com.lds.aluguel_carros.exception.UnauthorizedException;
import com.lds.aluguel_carros.services.UsuarioService;

@Aspect
@Component
public class UserTypeValidationAspect {

    private final UsuarioService usuarioService;

    public UserTypeValidationAspect(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @Around("@annotation(requiredUserType)")
    public Object validateUserType(ProceedingJoinPoint joinPoint, RequiredUserType requiredUserType) throws Throwable {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            throw new UnauthorizedException("Usuário não autenticado");
        }

        String userEmail = authentication.getName();
        Usuario usuario = usuarioService.loadUserByUsername(userEmail);

        boolean isAuthorized = false;
        for (Class<? extends Usuario> allowedType : requiredUserType.value()) {
            if (allowedType.isInstance(usuario)) {
                isAuthorized = true;
                break;
            }
        }

        if (!isAuthorized) {
            throw new UnauthorizedException("Tipo de usuário não autorizado para esta ação");
        }

        return joinPoint.proceed();
    }
}