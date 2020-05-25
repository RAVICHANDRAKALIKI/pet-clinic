package dev.ravi.petclinic.data.models;

import java.time.LocalDateTime;

public class Appointment extends BaseEntity{

    private Vet vet;
    private Pet pet;
    private LocalDateTime datetime;
    private String status;

    public Appointment(Vet vet, Pet pet, LocalDateTime datetime) {
        this.pet = pet;
        this.datetime = datetime;
        this.status = "Scheduled";
        this.vet = vet;
    }

    public void cancel() {
        this.status = "Cancelled";
    }

    public void complete() {
        this.status = "Completed";
    }

    public void reschedule(LocalDateTime datetime) {
        this.vet.getAppointmentList().forEach(app -> {
            if ( app.status.equals("Scheduled") | app.status.equals("Rescheduled") ) {
                if (datetime.equals(app.datetime)) {
                    throw new RuntimeException("Slot not available");
                }
            }
        });
        this.datetime = datetime;
        this.status = "Rescheduled";
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
