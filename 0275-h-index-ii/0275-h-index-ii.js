var hIndex = function(citations) {

    let low = 0;
    let high = citations.length - 1;

    while (low <= high) {

        let mid = Math.floor((low + high) / 2);

        let papers = citations.length - mid;

        if (citations[mid] < papers) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }

    return citations.length - low;
};