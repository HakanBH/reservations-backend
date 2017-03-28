package reservations.model;

import org.springframework.data.rest.core.annotation.RestResource;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Created by Trayan_Muchev on 1/16/2017.
 */
@Entity
@Table(name = "pending_rejected_reservations")
public class PendingAndRejectedReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id")
    @RestResource(exported = false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @NotNull
    private Facility facility;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @RestResource(exported = false)
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @NotNull
    private User user;

    @Min(value = 0)
    @Max(value = 23)
    @Column(name = "from_hour")
    private Integer fromHour;

    @Min(value = 0)
    @Max(value = 23)
    @Column(name = "to_hour")
    private Integer toHour;

    @Column(name = "date")
    private Date date;

    @Column(name = "deposit")
    private Boolean deposit;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "reservation_status_id")
    private ReservationStatus reservationStatus;

    public PendingAndRejectedReservation() {
    }

    public PendingAndRejectedReservation(Facility facility, User user, Integer fromHour, Integer toHour, Date date, Boolean deposit, ReservationStatus reservationStatus) {
        this.facility = facility;
        this.user = user;
        this.fromHour = fromHour;
        this.toHour = toHour;
        this.date = date;
        this.deposit = deposit;
        this.reservationStatus = reservationStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getFromHour() {
        return fromHour;
    }

    public void setFromHour(Integer fromHour) {
        this.fromHour = fromHour;
    }

    public Integer getToHour() {
        return toHour;
    }

    public void setToHour(Integer toHour) {
        this.toHour = toHour;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getDeposit() {
        return deposit;
    }

    public void setDeposit(Boolean deposit) {
        this.deposit = deposit;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }
}