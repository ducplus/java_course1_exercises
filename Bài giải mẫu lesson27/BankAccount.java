public class BankAccount {
    // các thuộc tính:
    public String accNumber;    // số tài khoản
    public String owner;        // chủ tài khoản
    public String type;         // loại tài khoản(vd: tiết kiệm)
    public long ballance;       // số dư
    public String bankName;     // tên ngân hàng
    public String startDate;    // ngày phát hành
    public String endDate;      // ngày hết hạn

    // phương thức khởi tạo mặc định
    public BankAccount() {
        accNumber = "";
        owner = "";
        type = "";
        ballance = 0;
        bankName = "";
        startDate = "";
        endDate = "";
    }

    // phương thức khởi tạo hai tham số
    public BankAccount(String accNumber, String owner) {
        this.accNumber = accNumber;
        this.owner = owner;
    }

    // nạp tiền vào tk ngân hàng
    public boolean deposit(long amount) {
        if (amount > 0) {
            ballance += amount;
            return true; // gửi tiền vào tk thành công
        }
        return false; // gửi tiền vào tài khoản thất bại
    }

    // rút tiền
    public boolean withdraw(long amount) {
        if (amount > 0 && amount < ballance) {
            ballance -= amount;
            return true;
        }
        return false; // rút thất bại
    }

    // chuyển khoản, giả định chỉ chuyển trong nội bộ ngân hàng
    // nếu chuyển ngoại tuyến thêm các thông tin khác vào
    public boolean bankTransfer(BankAccount acc, long amount) {
        // nếu khớp tên tài khoản, số tài khoản, số tiền cần chuyển hợp lệ
        if (0 < amount && amount < ballance
                && acc.accNumber.compareTo(accNumber) == 0
                && owner.compareTo(acc.owner) == 0) {
            ballance -= amount;
            return true; // chuyển khoản thành công
        }
        return false; // chuyển khoản thất bại
    }

    // kiểm tra số dư:
    public void checkAccBallance() {
        System.out.println("Số dư của bạn hiện tại là: " + ballance);
    }

    // thanh toán các dịch vụ khác
    public boolean pay(String service, long amount) {
        if (!service.isEmpty() && amount > 0 && amount < ballance) {
            ballance -= amount;
            return true; // thanh toán thành công
        }
        return false; // thanh toán thất bại
    }
}
