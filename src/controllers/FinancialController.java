package controllers;

import java.util.ArrayList;
import models.*;
import repositories.ProfessorRepository;
import repositories.AcquisitionRepository;

public class FinancialController {
    
    ArrayList<Professor> professors = ProfessorRepository.list();
    ArrayList<Acquisition> acquisitions = AcquisitionRepository.list();
    
    //Calcular salario professores
    public double calculateProfessorSalaries(){
        double salaryBalance = 0;

        for(int i = 0; i < professors.size(); i++){
            salaryBalance += professors.get(i).getWage();
        }
        return salaryBalance;
    }
    //Calcular aquisições
    public double calculateAcquisitions(){
        double acquisitionsBalance = 0;

        for(int i=0; i < acquisitions.size(); i++){
            acquisitionsBalance += acquisitions.get(i).getValue();
        }
        return acquisitionsBalance;
    }
    //Balanço de gastos
    public double calculateSpendingBalance(){
        return calculateAcquisitions() + calculateProfessorSalaries();
    }

}