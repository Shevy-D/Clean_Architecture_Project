package com.shevy.cleanarchitectureproject.domain.usecase

import com.shevy.cleanarchitectureproject.domain.models.UserName
import com.shevy.cleanarchitectureproject.domain.repository.UserRepository
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserNameUseCaseTest {

    val userRepository = mock<UserRepository>()

/*    @Mock
    lateinit var userRepository: UserRepository*/

    @Test
    fun `should return the same data as in repository`() {

        val testUserName = UserName(firstName = "test first name", lastName = "test last name")
        Mockito.`when`(userRepository.getName()).thenReturn(testUserName)

        val useCase = GetUserNameUseCase(userRepository = userRepository)
        val actual = useCase.execute()
        val expected = UserName(firstName = "test first name", lastName = "test last name")

        Assertions.assertEquals(expected, actual)
    }
}