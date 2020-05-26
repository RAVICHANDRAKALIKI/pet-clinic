package dev.ravi.petclinic.data.models;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment extends BaseEntity{

    @ManyToOne
    private Vet vet;

    @ManyToOne
    private Pet pet;

    @Column(name="date_time")
    private LocalDateTime datetime;

    @Enumerated(value = EnumType.STRING)
    @Column(name="status")
    private StatusType status;

    public Appointment() {
    }

    public Appointment(Vet vet, Pet pet, LocalDateTime datetime) {
        this.pet = pet;
        this.datetime = datetime;
        this.status = StatusType.SCHEDULED;
        this.vet = vet;
    }

    public void cancel() {
        this.status = StatusType.CANCELLED;
    }

    public void complete() {
        this.status = StatusType.COMPLETED;
    }

    public void reschedule(LocalDateTime datetime) {
        this.vet.getAppointmentList().forEach(app -> {
            if ( app.status.equals(StatusType.SCHEDULED) | app.status.equals(StatusType.RESCHEDULED) ) {
                if (datetime.equals(app.datetime)) {
                    throw new RuntimeException("Slot not available");
                }
            }
        });
        this.datetime = datetime;
        this.status = StatusType.RESCHEDULED;
    }

    public Vet getVet() {
        return vet;
    }

    public void setVet(Vet vet) {
        this.vet = vet;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setStatus(StatusType status) {
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
