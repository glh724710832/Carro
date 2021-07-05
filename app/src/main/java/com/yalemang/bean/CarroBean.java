package com.yalemang.bean;

import java.io.Serializable;
import java.util.List;


public class CarroBean implements Serializable {

    /**
     * data : {"id":12,"type":"subscription","make":"Mazda","model":"Mazda2","carplate_number":"SLT5334G","price":"1045.98","start_time":1587340800,"end_time":1589846400,"next_billing_date":1608307200,"mileage":null,"total_outstanding_fine_count":null,"total_outstanding_fine_amount":null,"earliest_payment_due_date":null,"total_per_km_rate":"0.00","days_left":null,"driven_this_month":0,"usage_due_this_month":0,"base_price":null,"road_tax":682,"insurance_excess":2000,"records":[{"key":"agreement-documents","label":"Agreement Documents"}],"has_subscribed_insurance":true,"help":[{"key":"faq","label":"FAQ","value":"https://carro.sg/leap#faq"},{"key":"terms_and_conditions","label":"Terms and conditions","value":"https://carro.sg/leap/terms"}],"updated_at":1597200772,"drivers":[{"name":"Driver A","phone":"90685298","gender":"MALE","id_number":"*****631Z","driver_type":"MAIN_DRIVER","date_of_birth":324727300,"marital_status":"MARRIED","driving_experience":"10","driving_license_number":"*****631Z","driving_license_registration_date":324727300}]}
     * success : {"message":"Retrieve subscription vehicle successfully!"}
     */

    private DataBean data;
    private SuccessBean success;


    public static class DataBean implements Serializable {
        /**
         * id : 12
         * type : subscription
         * make : Mazda
         * model : Mazda2
         * carplate_number : SLT5334G
         * price : 1045.98
         * start_time : 1587340800
         * end_time : 1589846400
         * next_billing_date : 1608307200
         * mileage : null
         * total_outstanding_fine_count : null
         * total_outstanding_fine_amount : null
         * earliest_payment_due_date : null
         * total_per_km_rate : 0.00
         * days_left : null
         * driven_this_month : 0
         * usage_due_this_month : 0
         * base_price : null
         * road_tax : 682
         * insurance_excess : 2000
         * records : [{"key":"agreement-documents","label":"Agreement Documents"}]
         * has_subscribed_insurance : true
         * help : [{"key":"faq","label":"FAQ","value":"https://carro.sg/leap#faq"},{"key":"terms_and_conditions","label":"Terms and conditions","value":"https://carro.sg/leap/terms"}]
         * updated_at : 1597200772
         * drivers : [{"name":"Driver A","phone":"90685298","gender":"MALE","id_number":"*****631Z","driver_type":"MAIN_DRIVER","date_of_birth":324727300,"marital_status":"MARRIED","driving_experience":"10","driving_license_number":"*****631Z","driving_license_registration_date":324727300}]
         */

        private int id;
        private String type;
        private String make;
        private String model;
        private String carplate_number;
        private String price;
        private int start_time;
        private int end_time;
        private int next_billing_date;
        private Object mileage;
        private Object total_outstanding_fine_count;
        private Object total_outstanding_fine_amount;
        private Object earliest_payment_due_date;
        private String total_per_km_rate;
        private Object days_left;
        private int driven_this_month;
        private int usage_due_this_month;
        private Object base_price;
        private int road_tax;
        private int insurance_excess;
        private boolean has_subscribed_insurance;
        private int updated_at;
        private List<RecordsBean> records;
        private List<HelpBean> help;
        private List<DriversBean> drivers;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getCarplate_number() {
            return carplate_number;
        }

        public void setCarplate_number(String carplate_number) {
            this.carplate_number = carplate_number;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public int getStart_time() {
            return start_time;
        }

        public void setStart_time(int start_time) {
            this.start_time = start_time;
        }

        public int getEnd_time() {
            return end_time;
        }

        public void setEnd_time(int end_time) {
            this.end_time = end_time;
        }

        public int getNext_billing_date() {
            return next_billing_date;
        }

        public void setNext_billing_date(int next_billing_date) {
            this.next_billing_date = next_billing_date;
        }

        public Object getMileage() {
            return mileage;
        }

        public void setMileage(Object mileage) {
            this.mileage = mileage;
        }

        public Object getTotal_outstanding_fine_count() {
            return total_outstanding_fine_count;
        }

        public void setTotal_outstanding_fine_count(Object total_outstanding_fine_count) {
            this.total_outstanding_fine_count = total_outstanding_fine_count;
        }

        public Object getTotal_outstanding_fine_amount() {
            return total_outstanding_fine_amount;
        }

        public void setTotal_outstanding_fine_amount(Object total_outstanding_fine_amount) {
            this.total_outstanding_fine_amount = total_outstanding_fine_amount;
        }

        public Object getEarliest_payment_due_date() {
            return earliest_payment_due_date;
        }

        public void setEarliest_payment_due_date(Object earliest_payment_due_date) {
            this.earliest_payment_due_date = earliest_payment_due_date;
        }

        public String getTotal_per_km_rate() {
            return total_per_km_rate;
        }

        public void setTotal_per_km_rate(String total_per_km_rate) {
            this.total_per_km_rate = total_per_km_rate;
        }

        public Object getDays_left() {
            return days_left;
        }

        public void setDays_left(Object days_left) {
            this.days_left = days_left;
        }

        public int getDriven_this_month() {
            return driven_this_month;
        }

        public void setDriven_this_month(int driven_this_month) {
            this.driven_this_month = driven_this_month;
        }

        public int getUsage_due_this_month() {
            return usage_due_this_month;
        }

        public void setUsage_due_this_month(int usage_due_this_month) {
            this.usage_due_this_month = usage_due_this_month;
        }

        public Object getBase_price() {
            return base_price;
        }

        public void setBase_price(Object base_price) {
            this.base_price = base_price;
        }

        public int getRoad_tax() {
            return road_tax;
        }

        public void setRoad_tax(int road_tax) {
            this.road_tax = road_tax;
        }

        public int getInsurance_excess() {
            return insurance_excess;
        }

        public void setInsurance_excess(int insurance_excess) {
            this.insurance_excess = insurance_excess;
        }

        public boolean isHas_subscribed_insurance() {
            return has_subscribed_insurance;
        }

        public void setHas_subscribed_insurance(boolean has_subscribed_insurance) {
            this.has_subscribed_insurance = has_subscribed_insurance;
        }

        public int getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(int updated_at) {
            this.updated_at = updated_at;
        }

        public List<RecordsBean> getRecords() {
            return records;
        }

        public void setRecords(List<RecordsBean> records) {
            this.records = records;
        }

        public List<HelpBean> getHelp() {
            return help;
        }

        public void setHelp(List<HelpBean> help) {
            this.help = help;
        }

        public List<DriversBean> getDrivers() {
            return drivers;
        }

        public void setDrivers(List<DriversBean> drivers) {
            this.drivers = drivers;
        }


        public static class RecordsBean implements Serializable {
            /**
             * key : agreement-documents
             * label : Agreement Documents
             */

            private String key;
            private String label;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }
        }


        public static class HelpBean implements Serializable {
            /**
             * key : faq
             * label : FAQ
             * value : https://carro.sg/leap#faq
             */

            private String key;
            private String label;
            private String value;

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }


        public static class DriversBean implements Serializable {
            /**
             * name : Driver A
             * phone : 90685298
             * gender : MALE
             * id_number : *****631Z
             * driver_type : MAIN_DRIVER
             * date_of_birth : 324727300
             * marital_status : MARRIED
             * driving_experience : 10
             * driving_license_number : *****631Z
             * driving_license_registration_date : 324727300
             */

            private String name;
            private String phone;
            private String gender;
            private String id_number;
            private String driver_type;
            private int date_of_birth;
            private String marital_status;
            private String driving_experience;
            private String driving_license_number;
            private int driving_license_registration_date;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getGender() {
                return gender;
            }

            public void setGender(String gender) {
                this.gender = gender;
            }

            public String getId_number() {
                return id_number;
            }

            public void setId_number(String id_number) {
                this.id_number = id_number;
            }

            public String getDriver_type() {
                return driver_type;
            }

            public void setDriver_type(String driver_type) {
                this.driver_type = driver_type;
            }

            public int getDate_of_birth() {
                return date_of_birth;
            }

            public void setDate_of_birth(int date_of_birth) {
                this.date_of_birth = date_of_birth;
            }

            public String getMarital_status() {
                return marital_status;
            }

            public void setMarital_status(String marital_status) {
                this.marital_status = marital_status;
            }

            public String getDriving_experience() {
                return driving_experience;
            }

            public void setDriving_experience(String driving_experience) {
                this.driving_experience = driving_experience;
            }

            public String getDriving_license_number() {
                return driving_license_number;
            }

            public void setDriving_license_number(String driving_license_number) {
                this.driving_license_number = driving_license_number;
            }

            public int getDriving_license_registration_date() {
                return driving_license_registration_date;
            }

            public void setDriving_license_registration_date(int driving_license_registration_date) {
                this.driving_license_registration_date = driving_license_registration_date;
            }
        }

    }


    public static class SuccessBean implements Serializable {
        /**
         * message : Retrieve subscription vehicle successfully!
         */

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }


    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public SuccessBean getSuccess() {
        return success;
    }

    public void setSuccess(SuccessBean success) {
        this.success = success;
    }
}

