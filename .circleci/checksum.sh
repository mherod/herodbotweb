#!/usr/bin/env bash
REPO_DIRECTORY=`git rev-parse --show-toplevel`
git clean -fXd

CHECKSUM_DUMP="$REPO_DIRECTORY/checksum_dump"
CHECKSUM="$REPO_DIRECTORY/checksum"

for ext in "kt" "kts" "xml" "gradle" "properties" "java" "yml" ; do
    echo "Summing ${ext} files"
    find ${REPO_DIRECTORY} -regex ".*/.*\.${ext}" -type f -print \
        | xargs -n1 openssl md5 \
	| grep -oh "herodbotweb/.*\$" \
	| sort \
        | tee ${CHECKSUM_DUMP}_${ext}
done

echo "Dumping source checksums"
CHECKSUM_DUMP_FILE=${CHECKSUM_DUMP}"_source"
echo "" > ${CHECKSUM_DUMP_FILE}
for ext in "kt" "kts" "xml" "gradle" "properties" "java" "yml" ; do
    echo ${ext}
    cat ${CHECKSUM_DUMP}_${ext} \
        | openssl md5 \
        | tee -a ${CHECKSUM_DUMP_FILE}
done

echo "Dumping build config checksums"
CHECKSUM_DUMP_FILE=${CHECKSUM_DUMP}"_config"
echo "" > ${CHECKSUM_DUMP_FILE}
for ext in "kts" "gradle" "properties" "yml" ; do
    echo ${ext}
    cat ${CHECKSUM_DUMP}_${ext} \
        | openssl md5 \
        | tee -a ${CHECKSUM_DUMP_FILE}
done
