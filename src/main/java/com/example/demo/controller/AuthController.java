
















    // Required by tests

;
    }

    public AuthController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAccount> register(@RequestBody RegisterRequest request) {
        UserAccount user = new UserAccount();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEmployeeId(request.getEmployeeId());




    











