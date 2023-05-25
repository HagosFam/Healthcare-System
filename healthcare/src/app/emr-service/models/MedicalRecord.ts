import { DiagnosisReport } from "./DiagnosisReport";
import { LaboratoryReport } from "./LaboratoryReport";

export class MedicalRecord {
    id: number=0;
    patientId: number=0;
    diagnosisReports!: DiagnosisReport[];
    laboratoryReports!: LaboratoryReport[];
    allergy: string[]=[""];
  }