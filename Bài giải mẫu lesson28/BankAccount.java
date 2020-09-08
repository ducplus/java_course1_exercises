/**
 * lớp này mô tả thông tin tài khoản ngân hàng của Wakanda
 *
 * @author Branium Academy
 * @website: https://braniumacademy.net
 */
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

    // phương thức khởi tạo 1 tham số
    public BankAccount(String accNumber) {
        this.accNumber = accNumber;
    }

    // phương thức khởi tạo 2 tham số
    public BankAccount(String accNumber, String owner) {
        this(accNumber); // gọi constructor 1 tham số
        this.owner = owner;
    }

    // phương thức khởi tạo 3 tham số
    public BankAccount(String accNumber, String owner, String type) {
        this(accNumber, owner); // gọi constructor 2 tham số
        this.type = type;
    }

    // phương thức khởi tạo 4 tham số
    public BankAccount(String accNumber, String owner,
                       String type, long ballance) {
        this(accNumber, owner, type); // gọi constructor 3 tham số
        this.ballance = ballance;
    }

    // phương thức khởi tạo 5 tham số
    public BankAccount(String accNumber, String owner,
                       String type, long ballance, String bankName) {
        this(accNumber, owner, type, ballance); // gọi constructor 4 tham số
        this.bankName = bankName;
    }

    // phương thức khởi tạo 6 tham số
    public BankAccount(String accNumber, String owner, String type,
                       long ballance, String bankName, String startDate) {
        // gọi constructor 5 tham số
        this(accNumber, owner, type, ballance, bankName);
        this.startDate = startDate;
    }

    // phương thức khởi tạo 7 tham số
    public BankAccount(String accNumber, String owner,
                       String type, long ballance,
                       String bankName, String startDate, String endDate) {
        // gọi constructor 6 tham số
        this(accNumber, owner, type, ballance, bankName, startDate);
        this.endDate = endDate;
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
