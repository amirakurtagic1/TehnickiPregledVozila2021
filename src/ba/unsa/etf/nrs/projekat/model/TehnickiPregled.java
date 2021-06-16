package ba.unsa.etf.nrs.projekat.model;

import java.time.LocalDate;

public class TehnickiPregled {

    private Integer etaNumber, enginePower, cubic, weight, doorCount, ecoCategory, seatsNumber, v;
    private String faultyVehiclesRecordId, technician_id, id, ownershipNumber, ownerId, contactNumber, transactionNumber, chassisNumber, motorNumber, licensePlate, barCode, color,
            drive, fuelType, transmissionType, carCategory, manufacturer, model;
    private LocalDate datumKreiranja;


    public TehnickiPregled(String faultyVehiclesRecordId, String technician_id,String id, String ownershipNumber, String ownerId, String contactNumber, String transactionNumber, String chassisNumber, String motorNumber, String licensePlate, String barCode,Integer etaNumber, Integer enginePower, String color,Integer cubic, Integer weight, String drive, String fuelType,Integer doorCount, String transmissionType, String carCategory,Integer ecoCategory, Integer seatsNumber, String manufacturer, String model, Integer v, LocalDate datumKreiranja) {
        this.faultyVehiclesRecordId = faultyVehiclesRecordId;
        this.technician_id = technician_id;
        this.etaNumber = etaNumber;
        this.enginePower = enginePower;
        this.cubic = cubic;
        this.weight = weight;
        this.doorCount = doorCount;
        this.ecoCategory = ecoCategory;
        this.seatsNumber = seatsNumber;
        this.v = v;
        this.id = id;
        this.ownershipNumber = ownershipNumber;
        this.ownerId = ownerId;
        this.contactNumber = contactNumber;
        this.transactionNumber = transactionNumber;
        this.chassisNumber = chassisNumber;
        this.motorNumber = motorNumber;
        this.licensePlate = licensePlate;
        this.barCode = barCode;
        this.color = color;
        this.drive = drive;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
        this.carCategory = carCategory;
        this.manufacturer = manufacturer;
        this.model = model;
        this.datumKreiranja = datumKreiranja;
    }

    public LocalDate getDatumKreiranja() {
        return datumKreiranja;
    }

    public void setDatumKreiranja(LocalDate datumKreiranja) {
        this.datumKreiranja = datumKreiranja;
    }

    public String getFaultyVehiclesRecordId() {
        return faultyVehiclesRecordId;
    }

    public void setFaultyVehiclesRecordId(String faultyVehiclesRecordId) {
        this.faultyVehiclesRecordId = faultyVehiclesRecordId;
    }

    public String getTechnician_id() {
        return technician_id;
    }

    public void setTechnician_id(String technician_id) {
        this.technician_id = technician_id;
    }

    public Integer getEtaNumber() {
        return etaNumber;
    }

    public void setEtaNumber(Integer etaNumber) {
        this.etaNumber = etaNumber;
    }

    public Integer getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(Integer enginePower) {
        this.enginePower = enginePower;
    }

    public Integer getCubic() {
        return cubic;
    }

    public void setCubic(Integer cubic) {
        this.cubic = cubic;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(Integer doorCount) {
        this.doorCount = doorCount;
    }

    public Integer getEcoCategory() {
        return ecoCategory;
    }

    public void setEcoCategory(Integer ecoCategory) {
        this.ecoCategory = ecoCategory;
    }

    public Integer getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Integer seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnershipNumber() {
        return ownershipNumber;
    }

    public void setOwnershipNumber(String ownershipNumber) {
        this.ownershipNumber = ownershipNumber;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getTransactionNumber() {
        return transactionNumber;
    }

    public void setTransactionNumber(String transactionNumber) {
        this.transactionNumber = transactionNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getMotorNumber() {
        return motorNumber;
    }

    public void setMotorNumber(String motorNumber) {
        this.motorNumber = motorNumber;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDrive() {
        return drive;
    }

    public void setDrive(String drive) {
        this.drive = drive;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    public String getCarCategory() {
        return carCategory;
    }

    public void setCarCategory(String carCategory) {
        this.carCategory = carCategory;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return id;
    }
}

