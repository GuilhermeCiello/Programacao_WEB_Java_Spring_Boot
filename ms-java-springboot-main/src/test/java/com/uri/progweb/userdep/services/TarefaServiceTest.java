package com.uri.progweb.userdep.services;

import com.uri.progweb.userdep.entities.Tarefa;
import com.uri.progweb.userdep.repositories.TarefaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DataJpaTest
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class TarefaServiceTest {

    @Mock
    private TarefaRepository tarefaRepository;

    @InjectMocks
    private TarefaService tarefaService;

    private Tarefa tarefa1;
    private Tarefa tarefa2;

    @BeforeEach
    void setUp() {
        tarefa1 = new Tarefa();
        tarefa1.setId(1L);
        tarefa1.setDescricao("Tarefa 1");
        tarefa1.setFinalizada(false);

        tarefa2 = new Tarefa();
        tarefa2.setId(2L);
        tarefa2.setDescricao("Tarefa 2");
        tarefa2.setFinalizada(false);
    }

    @Test
    void findAll() {
        when(tarefaRepository.findAll()).thenReturn(Arrays.asList(tarefa1, tarefa2));

        List<Tarefa> tarefas = tarefaService.findAll();
        assertNotNull(tarefas);
        assertEquals(2, tarefas.size());
        verify(tarefaRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        when(tarefaRepository.findById(1L)).thenReturn(Optional.of(tarefa1));

        Optional<Tarefa> tarefa = tarefaService.findById(1L);
        assertTrue(tarefa.isPresent());
        assertEquals(tarefa1.getDescricao(), tarefa.get().getDescricao());
        verify(tarefaRepository, times(1)).findById(1L);
    }

    @Test
    void save() {
        when(tarefaRepository.save(tarefa1)).thenReturn(tarefa1);

        Tarefa savedTarefa = tarefaService.save(tarefa1);
        assertNotNull(savedTarefa);
        assertEquals(tarefa1.getDescricao(), savedTarefa.getDescricao());
        verify(tarefaRepository, times(1)).save(tarefa1);
    }

    @Test
    void deleteById() {
        doNothing().when(tarefaRepository).deleteById(1L);

        tarefaService.deleteById(1L);
        verify(tarefaRepository, times(1)).deleteById(1L);
    }

    @Test
    void update() {
        when(tarefaRepository.save(tarefa1)).thenReturn(tarefa1);

        Tarefa updatedTarefa = tarefaService.update(tarefa1);
        assertNotNull(updatedTarefa);
        assertEquals(tarefa1.getDescricao(), updatedTarefa.getDescricao());
        verify(tarefaRepository, times(1)).save(tarefa1);
    }

}