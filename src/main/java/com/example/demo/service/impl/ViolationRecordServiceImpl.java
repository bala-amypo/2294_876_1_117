@Service
public class ViolationRecordServiceImpl implements ViolationRecordService {

    private final ViolationRecordRepository violationRepo;

    public ViolationRecordServiceImpl(ViolationRecordRepository violationRepo) {
        this.violationRepo = violationRepo;
    }

    @Override
    public ViolationRecord log(ViolationRecord violation) {
        return violationRepo.save(violation);
    }

    @Override
    public List<ViolationRecord> getUnresolvedViolations() {
        return violationRepo.findByResolvedFalse();
    }

    @Override
    public void markResolved(long id) {
        ViolationRecord record = violationRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Violation not found"));
        record.setResolved(true);
        violationRepo.save(record);
    }
}
