# Copyright (C) 2016 Freescale Semiconductor
# Copyright 2017-2018 NXP

DESCRIPTION = "i.MX System Controller Firmware"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=ab61cab9599935bfe9f700405ef00f28"
SECTION = "BSP"

inherit fsl-eula-unpack pkgconfig deploy

SRC_URI = "${FSL_MIRROR}/${PN}-${PV}.bin;fsl-eula=true"

SRC_URI[md5sum] = "3382d38fbe7b302179cdd8c5ffd06a76"
SRC_URI[sha256sum] = "57475de06649f56bdee7ce6353ea793eb4c837e0c00b13b84aee2fababc8bfe7"

S = "${WORKDIR}/${PN}-${PV}"

BOARD_TYPE ?= "mek"
SC_FIRMWARE_NAME ?= "mx8qm-mek-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8qm = "mx8qm-${BOARD_TYPE}-scfw-tcm.bin"
SC_FIRMWARE_NAME_mx8qxp = "mx8qx-${BOARD_TYPE}-scfw-tcm.bin"
symlink_name = "scfw_tcm.bin"

SYSROOT_DIRS += "/boot"

do_install () {
    install -d ${D}/boot
    install -m 0644 ${S}/${SC_FIRMWARE_NAME} ${D}/boot/
}

BOOT_TOOLS = "imx-boot-tools"

do_deploy () {
    install -d ${DEPLOYDIR}/${BOOT_TOOLS}
    install -m 0644 ${S}/${SC_FIRMWARE_NAME} ${DEPLOYDIR}/${BOOT_TOOLS}/
    cd ${DEPLOYDIR}/${BOOT_TOOLS}/
    rm -f ${symlink_name}
    ln -sf ${SC_FIRMWARE_NAME} ${symlink_name}
    cd -
}

addtask deploy after do_install

INHIBIT_PACKAGE_STRIP = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
PACKAGE_ARCH = "${MACHINE_ARCH}"

FILES_${PN} = "/boot"

COMPATIBLE_MACHINE = "(mx8qm|mx8qxp)"