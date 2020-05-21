import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size = 0;

    void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    void save(Resume resume) {
        storage[size] = resume;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        int deleteResumeIndex = -1;
        for (int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                deleteResumeIndex = i;
                break;
            }
        }
        if (size - deleteResumeIndex >= 0 && deleteResumeIndex != -1) {
            System.arraycopy(storage, deleteResumeIndex + 1, storage, deleteResumeIndex, size - deleteResumeIndex);
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    int size() {
        return size;
    }
}
