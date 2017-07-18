package org.bank

import org.scalatest.{BeforeAndAfter, FunSpec}

import scala.util.{Failure, Success}

/**
  * Created by prashant on 18/7/17.
  */
class BankAccountTest extends FunSpec with BeforeAndAfter {

  val bankAccount =  new BankAccount

  describe("A Bank Account") {

    it("should not be deposited with negative ammount"){
      bankAccount.deposit(-1) match {
        case Success(balance) => fail("deposited negative amount !!!")
        case Failure(e) => succeed
      }
    }

    it("should be deposited with positive ammount"){
      bankAccount.deposit(1) match {
        case Success(balance) => succeed
        case Failure(e) => fail("failed to deposit valid amount")
      }
    }

    it("should not withdrawn with negative ammount"){
      bankAccount.withdraw(-1) match {
        case Success(balance) => fail("withdrawn negative amount !!!")
        case Failure(e) => succeed
      }
    }

    it("should not be withdrawn with ammount greater than balance"){
      bankAccount.withdraw(2) match {
        case Success(balance) => fail("withdrawn with ammount greater than balance!!!")
        case Failure(e) => succeed
      }
    }

    it("should withdraw amount less than or equal to balance"){
      bankAccount.deposit(1)
      bankAccount.withdraw(1) match {
        case Success(balance) => succeed
        case Failure(e) => fail(e.getMessage)
      }
    }

  }



}
