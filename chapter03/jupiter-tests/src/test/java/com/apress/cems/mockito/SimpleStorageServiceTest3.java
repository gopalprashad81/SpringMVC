/*
Freeware License, some rights reserved

Copyright (c) 2019 Iuliana Cosmina

Permission is hereby granted, free of charge, to anyone obtaining a copy 
of this software and associated documentation files (the "Software"), 
to work with the Software within the limits of freeware distribution and fair use. 
This includes the rights to use, copy, and modify the Software for personal use. 
Users are also allowed and encouraged to submit corrections and modifications 
to the Software for the benefit of other users.

It is not allowed to reuse,  modify, or redistribute the Software for 
commercial use in any way, or for a user's educational materials such as books 
or blog articles without prior permission from the copyright holder. 

The above copyright notice and this permission notice need to be included 
in all copies or substantial portions of the software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS OR APRESS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/
package com.apress.cems.mockito;

import com.apress.cems.dao.Storage;
import com.apress.cems.repos.StorageRepo;
import com.apress.cems.services.impl.SimpleStorageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * @author Iuliana Cosmina
 * @since 1.0
 * Description: new-style using Mockito mocks with JUnit 5
 */
@ExtendWith(MockitoExtension.class)
class SimpleStorageServiceTest3 {
    static final Long STORAGE_ID = 1L;

    @Mock //Creates mock instance of the field it annotates
    private StorageRepo mockRepo;

    @InjectMocks
    private SimpleStorageService storageService;

    @Test
    void findByIdPositive() {
        Storage storage = new Storage();
        storage.setId(STORAGE_ID);
        when(mockRepo.findById(any(Long.class))).thenReturn(Optional.of(storage));

        Storage result = storageService.findById(STORAGE_ID);

        verify(mockRepo, times(1)).findById(any(Long.class));
        assertAll(
                () -> assertNotNull(result),
                () -> assertEquals(storage.getId(), result.getId())
        );
    }
}
